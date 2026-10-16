package com.example.data.repository

import com.example.data.model.GradleMilestone
import com.example.data.model.GradleTopic

object GradleData {
    val timeline = listOf(
        GradleMilestone(
            year = "2008 – 2013",
            title = "The Eclipse ADT & Apache Ant Era",
            description = "In the early days of Android, apps were built using the Eclipse IDE with the Android Development Tools (ADT) plugin and Apache Ant scripts. Builds were rigid, dependency management was manual (copying .jar files into /libs), and multi-variant builds were nearly impossible.",
            codeSnippet = "<!-- Old Ant build.xml file -->\n<project name=\"MyApp\" default=\"debug\">\n  <property file=\"local.properties\" />\n  <import file=\"\${sdk.dir}/tools/ant/build.xml\" />\n</project>"
        ),
        GradleMilestone(
            year = "May 2013",
            title = "Google I/O 2013: Android Studio & Gradle Announced",
            description = "At Google I/O 2013, Google engineering leads Tor Norbye and Xavier Ducrohet shocked the community by unveiling Android Studio (based on IntelliJ IDEA) and announcing Gradle with the Android Gradle Plugin (AGP) as the official build system for all Android development.",
            codeSnippet = "// First generation build.gradle (Groovy DSL)\napply plugin: 'com.android.application'\n\nandroid {\n    compileSdkVersion 19\n    buildToolsVersion \"19.0.0\"\n}"
        ),
        GradleMilestone(
            year = "2018 – 2019",
            title = "D8 Dexer & R8 Next-Gen Shrinker",
            description = "Google replaced the aging DX dexer and third-party ProGuard with D8 and R8. D8 drastically reduced dexing times and introduced Java 8+ API desugaring. R8 combined shrinking, desugaring, optimization, and obfuscation into a single lightning-fast step.",
            codeSnippet = "// gradle.properties\nandroid.enableD8=true\nandroid.enableR8=true"
        ),
        GradleMilestone(
            year = "2020 – 2022",
            title = "Gradle Kotlin DSL (.gradle.kts) Standard",
            description = "Google migrated the Android ecosystem from dynamic Groovy scripts to static Kotlin DSL (.gradle.kts). This brought compile-time type-safety, refactoring support, and instant IDE auto-completion directly to build files.",
            codeSnippet = "// Modern Kotlin DSL (build.gradle.kts)\nplugins {\n    alias(libs.plugins.android.application)\n    alias(libs.plugins.kotlin.compose)\n}"
        ),
        GradleMilestone(
            year = "2023 – Present",
            title = "Version Catalogs (libs.versions.toml) & KSP",
            description = "Standardized centralized dependency management via Version Catalogs (`libs.versions.toml`) and replaced slow Kotlin annotation processing (kapt) with Kotlin Symbol Processing (KSP), cutting compiler overhead in half for Room and serialization.",
            codeSnippet = "# gradle/libs.versions.toml\n[versions]\nagp = \"9.1.1\"\nkotlin = \"2.2.10\"\n\n[libraries]\nandroidx-compose-material3 = { group = \"androidx.compose.material3\", name = \"material3\" }"
        )
    )

    val topics = listOf(
        GradleTopic(
            id = "pipeline",
            title = "The Android Compilation Pipeline",
            subtitle = "From Source Code to Signed APK / AAB",
            summary = "How your Kotlin code, XML layouts, and drawables are transformed by Gradle into executable Dalvik bytecode and packaged into a cryptographically signed binary.",
            detailedExplanation = "Building an Android app involves several distinct compiler stages coordinated by the Android Gradle Plugin (AGP):\n\n" +
                "1. Code Compilation: Kotlin source files (.kt) are compiled by `kotlinc` and Java files (.java) by `javac` into standard JVM bytecode (.class).\n\n" +
                "2. Resource Compilation (AAPT2): Android Asset Packaging Tool 2 parses XML layouts, strings, and drawables into binary formats, generates the `R.java` symbol class, and outputs the `resources.arsc` lookup table.\n\n" +
                "3. D8 / R8 Dexing & Shrinking: The D8/R8 engine converts all JVM .class files into Dalvik Executable (.dex) bytecode that the Android Runtime (ART) can execute. R8 removes unused code, inline functions, and obfuscates class/method names.\n\n" +
                "4. Manifest Merging: AGP combines the app's AndroidManifest.xml with all imported library manifests into a single final manifest.\n\n" +
                "5. APK Packaging (zip): The APK Builder combines .dex files, compiled resources, assets, and native C/C++ libraries (.so) into an uncompressed archive.\n\n" +
                "6. Zipalign & Apksigner: Zipalign aligns uncompressed data on 4-byte boundaries so the OS can memory-map resources without RAM copying. Finally, `apksigner` applies cryptographic signatures (v1, v2, v3, v4) to guarantee binary integrity.",
            keyPoints = listOf(
                "kotlinc: Compiles Kotlin into JVM .class bytecode",
                "AAPT2: Compiles resources and compiles layouts to binary XML",
                "D8 / R8: Translates .class bytecodes into Android .dex format and performs dead-code elimination",
                "Zipalign: 4-byte RAM memory alignment optimization",
                "apksigner: Multi-scheme cryptographic signature verification"
            ),
            category = "Architecture",
            codeExample = "Source (.kt/.java) -> [kotlinc] -> .class -> [R8] -> classes.dex --\\\nResources (XML)    -> [AAPT2]  -> resources.arsc ---------------> [APK Builder] -> [Zipalign] -> [apksigner] -> app-release.apk\nLibraries (AAR)    -> Manifest Merger ---------------------------/"
        ),
        GradleTopic(
            id = "ksp",
            title = "KSP (Kotlin Symbol Processing)",
            subtitle = "Replacing Kapt for 2x Faster Builds",
            summary = "Kotlin Symbol Processing is an idiomatic compiler plugin API built directly on top of the Kotlin compiler frontend, eliminating the slow Java stub generation required by legacy kapt.",
            detailedExplanation = "Legacy annotation processing tools like Room and Moshi historically relied on Java's `apt` (Annotation Processing Tool) via Kotlin's `kapt` plugin. Kapt had to generate temporary Java stubs for every Kotlin file before running Java processors, adding huge build time penalties.\n\n" +
                "Google co-developed KSP to read Kotlin Abstract Syntax Trees (AST) directly without generating stubs. In real-world Android projects, migrating from kapt to KSP reduces incremental annotation processing time by up to 50% to 100%!",
            keyPoints = listOf(
                "Reads Kotlin symbols directly from the Kotlin compiler",
                "Eliminates Java stub generation overhead entirely",
                "Up to 2x faster annotation processing in Room, Moshi, and Hilt",
                "Version-aligned directly with the project's Kotlin compiler release"
            ),
            category = "Performance",
            codeExample = "// In build.gradle.kts\nplugins {\n    alias(libs.plugins.google.devtools.ksp)\n}\n\ndependencies {\n    ksp(libs.androidx.room.compiler)\n    ksp(libs.moshi.kotlin.codegen)\n}"
        ),
        GradleTopic(
            id = "caches",
            title = "Configuration Cache & Build Cache",
            subtitle = "Zero-Overhead Re-execution",
            summary = "How Gradle skips tasks and caches execution graphs to turn 2-minute builds into 3-second instant iterations.",
            detailedExplanation = "Modern Gradle uses three layers of performance acceleration:\n\n" +
                "1. Incremental Build: Every Gradle task declares @Input and @Output properties. If inputs haven't changed, Gradle skips the task with status `UP-TO-DATE`.\n\n" +
                "2. Build Cache: Gradle hashes task inputs and stores outputs in a local or remote cache. Even if you run `clean` or switch git branches, Gradle pulls compiled outputs from the cache instead of recompiling.\n\n" +
                "3. Configuration Cache: Normally, Gradle spends 3-10 seconds configuring plugins and scripts before building. Configuration Cache records the resolved execution task graph and reuses it across builds, bypassing script evaluation entirely.",
            keyPoints = listOf(
                "UP-TO-DATE task status prevents redundant work",
                "Local and remote build cache shares outputs across developer teams",
                "Configuration Cache bypasses the configuration phase on repeat runs",
                "Gradle Daemon keeps a warm JVM in memory between terminal commands"
            ),
            category = "Performance",
            codeExample = "# gradle.properties\norg.gradle.caching=true\norg.gradle.configuration-cache=true\norg.gradle.parallel=true\norg.gradle.jvmargs=-Xmx4g -XX:+UseParallelGC"
        ),
        GradleTopic(
            id = "version_catalogs",
            title = "Version Catalogs (libs.versions.toml)",
            subtitle = "Type-Safe Centralized Dependency Governance",
            summary = "The modern standard for declaring libraries, plugins, and dependencies across all modules in one declarative TOML file.",
            detailedExplanation = "Prior to Version Catalogs, Android projects suffered from scattered dependency versions across multiple build.gradle files, leading to version conflicts. Version Catalogs provide a single `gradle/libs.versions.toml` file split into four sections:\n\n" +
                "• [versions]: Central definitions of library versions.\n" +
                "• [libraries]: Specific library artifacts mapped to versions.\n" +
                "• [bundles]: Groups of libraries imported together.\n" +
                "• [plugins]: Gradle plugins and their versions.\n\n" +
                "AGP generates type-safe accessors in Kotlin DSL: kebab-case keys like `androidx-core-ktx` automatically become `libs.androidx.core.ktx` with full autocomplete and refactoring safety.",
            keyPoints = listOf(
                "Single source of truth for all library and plugin versions",
                "Type-safe Kotlin accessors generated by Gradle",
                "Prevents version mismatch conflicts in multi-module projects",
                "Supported natively by Dependabot and Renovate automated update bots"
            ),
            category = "Best Practices",
            codeExample = "# gradle/libs.versions.toml\n[versions]\ncomposeBom = \"2024.09.00\"\n\n[libraries]\nandroidx-compose-bom = { group = \"androidx.compose\", name = \"compose-bom\", version.ref = \"composeBom\" }\n\n// In app/build.gradle.kts\nimplementation(platform(libs.androidx.compose.bom))"
        ),
        GradleTopic(
            id = "r8_proguard",
            title = "R8 Shrinking, Obfuscation & Desugaring",
            subtitle = "Making APKs 60% Smaller and Reverse-Engineer Proof",
            summary = "The Google-developed whole-program optimizer that trims unused bytecode, flattens class hierarchies, and renames identifiers to prevent code theft.",
            detailedExplanation = "R8 is Google's replacement for ProGuard. When compiling release builds (`isMinifyEnabled = true`), R8 performs four critical optimizations:\n\n" +
                "1. Shrinking (Tree Shaking): Analyzes code from entry points (Activities, Services from AndroidManifest) and strips every unreferenced class, field, and method.\n\n" +
                "2. Optimization: Rewrites bytecode for speed, inlines small functions, removes dead branches, and optimizes virtual method calls.\n\n" +
                "3. Obfuscation: Renames remaining classes, methods, and variables to short, unreadable characters (e.g. `com.example.NetworkService.fetchUser()` becomes `a.b.c()`).\n\n" +
                "4. Desugaring: Allows developers to use modern Java 8+ language features (streams, lambdas, java.time APIs) on older Android devices running Android 7 or below.",
            keyPoints = listOf(
                "Shrinks APK file sizes by up to 60%",
                "Prevents reverse-engineering by obfuscating symbol names",
                "Java 8+ backporting via bytecode desugaring",
                "Controlled via keep rules in proguard-rules.pro"
            ),
            category = "Security & Optimization",
            codeExample = "// In app/build.gradle.kts\nbuildTypes {\n    release {\n        isMinifyEnabled = true\n        isShrinkResources = true\n        proguardFiles(getDefaultProguardFile(\"proguard-android-optimize.txt\"), \"proguard-rules.pro\")\n    }\n}"
        )
    )
}
