package com.example.data.repository

import com.example.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object GeminiRepository {
    private const val MODEL_NAME = "gemini-3.5-flash"
    private const val BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models"

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    private const val SYSTEM_INSTRUCTION = """
You are Bugdroid AI, the world's foremost expert and enthusiast on Android OS history, Google engineering innovations, hardware milestones (G1, Nexus, Pixel), Android vs iOS counterparts, killed/removed features (The Android Graveyard), and the Gradle build system.
Your mission is to explain Android concepts and history clearly, accurately, and enthusiastically to anyone who wants to learn more.
Always maintain a helpful, friendly, and historically grounded tone. Structure answers with clear bullet points and highlight why Google made specific decisions.
"""

    suspend fun askGemini(prompt: String): String = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Exception) {
            ""
        }

        // If key is missing or default placeholder, check local expert knowledge base
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext getLocalExpertKnowledgeResponse(prompt)
        }

        val url = "$BASE_URL/$MODEL_NAME:generateContent?key=$apiKey"

        try {
            val jsonBody = JSONObject().apply {
                val contentsArray = JSONArray().apply {
                    put(JSONObject().apply {
                        val partsArray = JSONArray().apply {
                            put(JSONObject().apply {
                                put("text", prompt)
                            })
                        }
                        put("parts", partsArray)
                    })
                }
                put("contents", contentsArray)

                val systemInstObj = JSONObject().apply {
                    val sysPartsArray = JSONArray().apply {
                        put(JSONObject().apply {
                            put("text", SYSTEM_INSTRUCTION)
                        })
                    }
                    put("parts", sysPartsArray)
                }
                put("systemInstruction", systemInstObj)
            }

            val mediaType = "application/json; charset=utf-8".toMediaType()
            val requestBody = jsonBody.toString().toRequestBody(mediaType)

            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()

            val response = okHttpClient.newCall(request).execute()
            val responseBody = response.body?.string()

            if (response.isSuccessful && !responseBody.isNullOrBlank()) {
                val parsed = JSONObject(responseBody)
                val candidates = parsed.optJSONArray("candidates")
                if (candidates != null && candidates.length() > 0) {
                    val candidate = candidates.getJSONObject(0)
                    val content = candidate.optJSONObject("content")
                    val parts = content?.optJSONArray("parts")
                    if (parts != null && parts.length() > 0) {
                        val text = parts.getJSONObject(0).optString("text")
                        if (text.isNotBlank()) {
                            return@withContext text
                        }
                    }
                }
                return@withContext "Bugdroid received an empty response. Please ask another question about Android history!"
            } else {
                // If the remote call encounters an issue (e.g. invalid key or network error), fallback to expert local answers
                val fallbackAnswer = getLocalExpertKnowledgeResponse(prompt)
                return@withContext "$fallbackAnswer\n\n*(Note: Remote API returned code ${response.code}. You can configure your custom Gemini API key in the AI Studio Secrets panel).* "
            }
        } catch (e: Exception) {
            val localFallback = getLocalExpertKnowledgeResponse(prompt)
            return@withContext "$localFallback\n\n*(Offline mode: Could not reach Gemini servers (${e.localizedMessage})).* "
        }
    }

    private fun getLocalExpertKnowledgeResponse(query: String): String {
        val q = query.lowercase()
        return when {
            q.contains("buy") || q.contains("acquire") || q.contains("2005") || q.contains("andy rubin") -> {
                """
🤖 **Why Google Acquired Android in 2005**

In July 2005, Google quietly acquired **Android Inc.** (founded in 2003 by Andy Rubin, Rich Miner, Nick Sears, and Chris White) for approximately $50 million.

• **The Threat of Microsoft and Carriers:** Google's leadership (Larry Page and Sergey Brin) feared that Microsoft (with Windows Mobile) and closed telecom carriers would control the mobile gateway, blocking Google Search and mobile ads.
• **From Camera OS to Smartphone OS:** Andy Rubin's team originally planned to build an OS for digital cameras, but pivoted to mobile phones when camera sales stalled.
• **The Open Handset Alliance (2007):** In November 2007, Google spearheaded the Open Handset Alliance with 34 hardware makers and telecom operators (HTC, Qualcomm, T-Mobile), declaring Android an open, royalty-free operating system based on Linux.
• **The Outcome:** The acquisition created the world's most dominant operating system, powering over 3.5 billion active devices globally today!
                """.trimIndent()
            }
            q.contains("dalvik") || q.contains("art") || q.contains("runtime") -> {
                """
🤖 **Dalvik VM vs. Android Runtime (ART)**

• **Dalvik (2008 – 2014):** Created by Dan Bornstein, Dalvik was a register-based virtual machine designed to run on resource-constrained hardware. It executed DEX bytecode using an interpreter, and later a JIT (Just-In-Time) compiler in Froyo. However, bytecode had to be compiled every time an app launched, wasting CPU cycles and draining battery.

• **Android Runtime / ART (Android 5.0 Lollipop – Present):**
  1. **Ahead-of-Time (AOT):** Initially compiled entire apps to native machine code during installation.
  2. **Hybrid JIT + AOT (Android 7.0 Nougat):** Uses a fast JIT compiler while the user is actively using the app, profile-logs hot code paths, and compiles them to native machine code overnight while charging (Profile-Guided Optimization).
  3. **Performance:** Eliminates UI stutter, reduces garbage collection pause times to under 3 milliseconds, and supports 64-bit architectures natively!
                """.trimIndent()
            }
            q.contains("treble") || q.contains("fragmentation") || q.contains("updates") -> {
                """
🤖 **Project Treble: The Anti-Fragmentation Revolution**

Introduced in **Android 8.0 Oreo (2017)**, Project Treble was the most massive architectural refactoring in Android's history.

• **The Problem:** Previously, Android was a monolithic stack. When Google released an OS update, silicon chipmakers (Qualcomm, MediaTek) had to rewrite low-level drivers, and phone makers (Samsung, LG) had to port their skins, taking 9–18 months.
• **The Solution:** Google decoupled the Android OS Framework from the silicon hardware drivers via a stable **Vendor Interface (HIDL / AIDL)**.
• **The Result:** The system partition (`system.img`) can now be updated independently without touching the vendor partition (`vendor.img`). This enabled Generic System Images (GSIs) and laid the foundation for Google's current **7-year OS update commitment** on modern Pixel phones!
                """.trimIndent()
            }
            q.contains("gradle") || q.contains("build") || q.contains("ant") -> {
                """
🤖 **Gradle & The Android Build System**

• **Before 2013 (Eclipse ADT & Ant):** Android projects were built with Eclipse and Apache Ant. Builds were rigid, slow, and multi-variant builds (like staging vs. production) required hacking scripts.
• **Google I/O 2013:** Google announced **Gradle** with the **Android Gradle Plugin (AGP)** as the official build system alongside Android Studio.
• **Why Gradle Won:**
  1. **Flexible Build Variants:** Seamlessly generate `debug`, `release`, and custom flavors (paid vs. free) with different package IDs and API endpoints.
  2. **Modern Kotlin DSL (.gradle.kts):** Provides compile-time type-safety and IDE autocomplete.
  3. **KSP (Kotlin Symbol Processing):** 2x faster than legacy kapt annotation processing for libraries like Room.
  4. **Compilation Pipeline:** Code (.kt) -> javac/kotlinc -> .class -> D8/R8 -> .dex -> AAPT2 resources -> APK Builder -> Zipalign -> Apksigner!
                """.trimIndent()
            }
            q.contains("nexus") || q.contains("pixel") || q.contains("kill") -> {
                """
🤖 **Why Google Replaced Nexus with Pixel in 2016**

• **The Nexus Mission (2010 – 2015):** The Nexus series (built by HTC, Samsung, LG, Motorola, and Huawei) was created as developer reference hardware. They showcased clean, pure Android at budget-friendly prices (e.g. Nexus 4 for $299, Nexus 5 for $349), but often featured mediocre cameras, cheap plastic chassis, and zero retail marketing.
• **The Shift to Pixel (2016 – Present):**
  1. Google realized that reference devices couldn't compete with the Apple iPhone in mainstream consumer mindshare.
  2. "Made by Google" was formed to control hardware, industrial design, and custom silicon end-to-end.
  3. Pixel debuted computational photography (HDR+, Night Sight, Magic Eraser) and custom Google Tensor silicon co-engineered for machine learning!
                """.trimIndent()
            }
            q.contains("graveyard") || q.contains("removed") || q.contains("beam") -> {
                """
🤖 **Iconic Features Google Killed from Android**

Google is famous for ruthlessly pruning features:
• **Android Beam (NFC tap):** Introduced in 4.0, killed in Android 10. Replaced by Quick Share.
• **Lock Screen Widgets:** Introduced in 4.2 Jelly Bean, killed in 5.0 Lollipop for notification cards.
• **Daydream VR:** Headset VR mode killed in Android 11 as mobile VR gave way to standalone headsets.
• **Now on Tap:** Contextual OCR assistant in 6.0 Marshmallow, replaced by Google Assistant and Circle to Search.
• **Project Ara:** Magnetic modular phone hardware concept cancelled in 2016.
• **Hardware Menu Button:** Deprecated in Honeycomb 3.0, replaced by on-screen 3-dot overflow menus.
• **Public Dessert Names:** Ended with Android 10 to establish cleaner global numbering.
                """.trimIndent()
            }
            else -> {
                """
🤖 **Welcome to the Android Chronicle!**

Android has evolved from an ambitious open-source experiment into the world's most versatile computing platform powering phones, tablets, foldables, watches, TVs, and cars.

**Key Historical Pillars:**
• **2008 – 2010 (Foundations):** T-Mobile G1, free turn-by-turn Google Maps, notification shade, and the Dalvik JIT compiler.
• **2011 – 2013 (Holo Era):** Matías Duarte brings the Tron-inspired Holo theme, virtual soft navigation buttons, and Project Butter (60 FPS VSYNC).
• **2014 – 2020 (Material & Treble):** Material Design, the 64-bit ART runtime, runtime permissions, Project Treble driver decoupling, and Project Mainline modular Play updates.
• **2021 – Present (Material You & AI):** Dynamic color extraction, custom Google Tensor silicon, 7 years of OS updates, and on-device Gemini Nano multimodal intelligence!

*Tip: Try asking about "Project Treble", "Why Google bought Android", "Dalvik vs ART", "Android Graveyard", or "How Gradle works"!*
                """.trimIndent()
            }
        }
    }
}
