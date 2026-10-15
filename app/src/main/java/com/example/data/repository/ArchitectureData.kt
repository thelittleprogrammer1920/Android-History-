package com.example.data.repository

import com.example.data.model.ArchitectureTopic

object ArchitectureData {
    val topics = listOf(
        ArchitectureTopic(
            id = "treble",
            title = "Project Treble",
            subtitle = "The Great Architecture Partitioning",
            introducedEra = "Android 8.0 Oreo (2017)",
            problemStatement = "Android fragmentation was the platform's biggest vulnerability. Whenever Google released a new Android version, chipmakers (Qualcomm, MediaTek) had to rewrite custom low-level device drivers, and OEMs (Samsung, Xiaomi, LG) had to port their entire framework, delaying updates by 9 to 18 months or abandoning devices altogether.",
            googleSolution = "Google split the monolithic Android OS into two isolated layers: the Android OS Framework and the Vendor Implementation. A formal Vendor Interface (VINTF/HIDL) decoupled hardware drivers from the core OS. Google could now update the framework image (system.img) without touching vendor drivers (vendor.img).",
            technicalImpact = listOf(
                "Vendor Interface Definition Language (HIDL / AIDL) establishing strict ABI stability contracts.",
                "Generic System Images (GSIs) allowing pure Android to boot on any Treble-compliant hardware.",
                "Cut OEM major OS update delivery time in half across the entire global Android ecosystem.",
                "Enabled multi-year update guarantees and the modern 7-year update promises."
            ),
            diagramBefore = "[ Monolithic Android OS + OEM Apps + Chipset Drivers All Intertwined ]\n-> Updating Android required recompiling drivers from Qualcomm & MediaTek.",
            diagramAfter = "[ Android OS Framework (Google system.img) ]\n       ||  <-- Formal Vendor Interface (HIDL / AIDL) -->\n[ Vendor Silicon Drivers & OEM Hardware HAL (vendor.img) ]\n-> Google OS updates install independently without touching vendor code!",
            accentColorHex = 0xFFFFC107
        ),
        ArchitectureTopic(
            id = "art",
            title = "Dalvik VM to Android Runtime (ART)",
            subtitle = "The Native Ahead-of-Time & JIT Hybrid Engine",
            introducedEra = "Android 4.4 (Preview) / 5.0 (Default)",
            problemStatement = "Early Android ran on the Dalvik Virtual Machine, executing DEX bytecode interpreted at runtime. Even with Dalvik's JIT compiler added in Froyo, code was recompiled repeatedly every time apps launched, causing high CPU consumption, battery drain, and frame drops.",
            googleSolution = "Google designed the Android Runtime (ART) from the ground up. In Android 5.0, ART used Ahead-of-Time (AOT) compilation, compiling DEX bytecode into native machine ELF binaries during app installation. In Android 7.0 Nougat, Google perfected this by creating a hybrid JIT + AOT compiler with Profile-Guided Optimization (PGO): frequently used code paths are compiled to native machine code overnight while charging.",
            technicalImpact = listOf(
                "Ahead-of-Time (AOT) native compilation eliminated interpreter overhead.",
                "Profile-Guided Optimization (PGO) compiles only frequently used code paths, saving storage space.",
                "Overhauled Garbage Collection (GC) reducing GC pauses to under 3 milliseconds (preventing jank).",
                "Full support for 64-bit architectures (ARM64, x86_64)."
            ),
            diagramBefore = "[ Dalvik VM: DEX Bytecode ] -> [ Interpreter / Basic JIT ] -> [ CPU Execution ]\n-> Bytecode re-translated on every app launch, burning CPU cycles.",
            diagramAfter = "[ ART Runtime ] -> [ Hybrid JIT + Profiler while in use ] -> [ Idle Maintenance AOT Compilation ]\n-> Heavily used code converted directly to native machine code binaries!",
            accentColorHex = 0xFFFF5722
        ),
        ArchitectureTopic(
            id = "mainline",
            title = "Project Mainline",
            subtitle = "Modular OS Updates via Google Play",
            introducedEra = "Android 10 (2019)",
            problemStatement = "Even after Project Treble, critical operating system security patches and core media codecs still required full firmware Over-The-Air (OTA) updates distributed by OEMs and verified by cellular carriers.",
            googleSolution = "Google introduced the APEX (Android Pony EXpress) package format. APEX containers wrap core OS libraries (like Media Codecs, Conscrypt cryptography, DNS resolvers, and ART itself) and allow Google to update them directly through the Google Play Store—exactly like updating a regular app—without requiring carrier approval or rebooting into recovery mode.",
            technicalImpact = listOf(
                "APEX container format loaded early in the Linux boot sequence by apexd.",
                "Over 30 core OS modules updated directly by Google across all Android 10+ devices.",
                "Critical Zero-Day security vulnerabilities patched in days across billions of devices.",
                "Standardized Android Runtime (ART) as an updatable Mainline module in Android 12."
            ),
            diagramBefore = "[ Bug found in OS Media Codec ] -> [ OEM writes patch ] -> [ Carrier QA ] -> [ 6 Month Wait OTA ]",
            diagramAfter = "[ Bug found in OS Media Codec ] -> [ Google pushes APEX module via Google Play ] -> [ Patched in 24 Hours! ]",
            accentColorHex = 0xFF26A69A
        ),
        ArchitectureTopic(
            id = "butter",
            title = "Project Butter",
            subtitle = "Achieving 60 FPS Fluidity & VSYNC",
            introducedEra = "Android 4.1 Jelly Bean (2012)",
            problemStatement = "Early Android suffered from notorious visual 'stutter' and input lag compared to iOS. Frame rendering was unsynchronized with the display hardware's physical refresh rate, causing torn frames and dropped redraws.",
            googleSolution = "Google launched Project Butter, introducing VSYNC timing pulses every 16.6 milliseconds, Triple Buffering (CPU, GPU, and Display hardware all working in synchronized pipeline stages), and Touch Anticipation (predicting where your finger will land to start rendering earlier).",
            technicalImpact = listOf(
                "Introduced the Choreographer class, aligning animation ticks strictly with display VSYNC.",
                "Triple buffering prevented CPU/GPU frame stalls if a complex frame took slightly longer than 16ms.",
                "Touch response boosted CPU clock frequencies instantly when fingers made physical contact.",
                "SysTrace performance tool released for developers to profile rendering pipeline bottlenecks."
            ),
            diagramBefore = "[ Touch Input ] ~~~ (Random Timing) ~~~> [ Rendering ] -> [ Missed VSYNC ] -> Visual Stutter!",
            diagramAfter = "[ 16.6ms VSYNC Pulse ] =====> [ Input Handling ] -> [ Animation Tick ] -> [ GPU Buffer ] -> Locked 60 FPS!",
            accentColorHex = 0xFF00E5FF
        ),
        ArchitectureTopic(
            id = "svelte",
            title = "Project Svelte",
            subtitle = "Slimming Android for 512MB RAM",
            introducedEra = "Android 4.4 KitKat (2013)",
            problemStatement = "As Android grew more complex, memory requirements climbed. Low-cost devices in developing markets could only afford 512MB of RAM, causing severe memory paging and app crashes that excluded billions of potential users.",
            googleSolution = "Google launched Project Svelte to ruthlessly trim RAM footprint across the entire OS stack. Google added zRAM (compressed in-memory swap), killed memory-hungry background processes, capped background service consumption, and introduced the ActivityManager.isLowRamDevice() API.",
            technicalImpact = listOf(
                "Enabled Android 4.4 KitKat to run smoothly on devices with as little as 512MB RAM.",
                "Integrated zRAM kernel memory compression, effectively doubling available working memory.",
                "Procstats tool created to profile and visualize app RAM consumption over 24-hour periods.",
                "Laid the technical foundation for what would later become Android Go edition."
            ),
            diagramBefore = "[ 512MB RAM Device ] -> High OS overhead (350MB) leaves only 150MB for apps -> Crashes & OOM kills.",
            diagramAfter = "[ 512MB RAM + Project Svelte ] -> Stripped OS services + zRAM compression -> Smooth multitasking!",
            accentColorHex = 0xFFD32F2F
        ),
        ArchitectureTopic(
            id = "volta",
            title = "Project Volta",
            subtitle = "Battery Efficiency & JobScheduler",
            introducedEra = "Android 5.0 Lollipop (2014)",
            problemStatement = "Apps ran wild in the background, waking the phone's CPU from deep sleep every few minutes to check servers or ping GPS, draining battery life even when the user wasn't using the device.",
            googleSolution = "Google introduced Project Volta, anchored by the JobScheduler API. Instead of individual apps waking up the modem and CPU independently, JobScheduler batches deferred background jobs together when the phone is connected to unmetered Wi-Fi or plugged into a charger.",
            technicalImpact = listOf(
                "JobScheduler API revolutionized background task execution and power management.",
                "Battery Historian tool released to visualize power consumption and CPU wake locks.",
                "Native Battery Saver mode throttling CPU frequencies and dropping display refresh rates.",
                "Evolved into Doze Mode in Marshmallow and App Standby Buckets in Pie."
            ),
            diagramBefore = "[ App A wakes CPU @ 2:01 ] ... [ App B wakes CPU @ 2:04 ] ... [ App C wakes CPU @ 2:07 ] -> Battery drains!",
            diagramAfter = "[ JobScheduler ] -> Waits until device is charging or on Wi-Fi -> Batches [ A + B + C ] in single wake cycle!",
            accentColorHex = 0xFFFF9800
        ),
        ArchitectureTopic(
            id = "compose",
            title = "Jetpack Compose",
            subtitle = "The Modern Declarative UI Paradigm",
            introducedEra = "2021 (Modern Era)",
            problemStatement = "For 13 years, Android UI relied on imperative XML layout hierarchies, findViewById(), and the massive, mutable 30,000-line View.java class. State synchronization between business logic and UI views was fragile and prone to UI bugs and memory leaks.",
            googleSolution = "Google completely redesigned Android UI engineering with Jetpack Compose. Compose is a reactive, declarative UI toolkit written 100% in Kotlin. Developers describe UI as pure functions that transform state into pixels. When state changes, Compose automatically executes intelligent recomposition only on elements that need updating.",
            technicalImpact = listOf(
                "Eliminated fragile XML files, custom View subclasses, and manual UI state mutation.",
                "Kotlin Compiler Plugin with smart positional memoization for high-speed recomposition.",
                "Seamless integration with Kotlin Coroutines, StateFlow, and Material Design 3 tokens.",
                "Drastically reduced app codebases by 40-60% while accelerating development speed."
            ),
            diagramBefore = "[ XML Layout ] <---> [ Java / Kotlin Activity ] <---> [ findViewById() ] <---> [ Manual UI Mutations ]",
            diagramAfter = "[ State (StateFlow) ] =====> [ @Composable fun UI(state) ] =====> [ Automatic Smart Recomposition! ]",
            accentColorHex = 0xFF7C4DFF
        ),
        ArchitectureTopic(
            id = "tensor_ai",
            title = "Custom Tensor Silicon & Gemini Nano",
            subtitle = "The Era of On-Device Foundation Models",
            introducedEra = "Android 14 – 15 (2023–2024)",
            problemStatement = "Cloud-based Large Language Models introduce latency, require active cellular data, and send sensitive personal information over the internet, preventing real-time on-device assistance.",
            googleSolution = "Google co-engineered custom Tensor silicon (G3/G4) with Android OS-level integration for Gemini Nano. Gemini Nano is Google's most efficient foundation model running locally on smartphone NPUs with 4-bit quantization, performing multimodal voice, image, and text tasks entirely offline with zero cloud latency.",
            technicalImpact = listOf(
                "AICore system service managing on-device foundation models securely behind permissions.",
                "Dedicated memory partition for local LLM weights without compromising gaming or app RAM.",
                "Enables Magic Compose, Pixel Recorder summarization, Call Notes, and Pixel Screenshots locally.",
                "Complete on-device privacy: personal data never leaves the smartphone hardware boundary."
            ),
            diagramBefore = "[ Audio / Text ] ---> [ Cellular Network ] ---> [ Remote Cloud LLM ] ---> Latency + Privacy risks",
            diagramAfter = "[ Audio / Text ] ===> [ Local Tensor TPU + Gemini Nano in AICore ] ===> Instant offline intelligence!",
            accentColorHex = 0xFF4CAF50
        )
    )
}
