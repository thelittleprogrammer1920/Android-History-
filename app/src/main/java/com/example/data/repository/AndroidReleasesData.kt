package com.example.data.repository

import com.example.data.model.AndroidEra
import com.example.data.model.AndroidRelease
import com.example.data.model.EasterEggInfo
import com.example.data.model.EasterEggType
import com.example.data.model.FeatureHighlight
import com.example.data.model.HardwareMilestoneRef

object AndroidReleasesData {
    val releases = listOf(
        AndroidRelease(
            id = "android_1_0",
            versionName = "1.0",
            dessertName = "Base / Apple Pie",
            internalCodename = "Apple Pie",
            apiLevel = 1,
            releaseDate = "September 23, 2008",
            year = 2008,
            era = AndroidEra.EARLY_FOUNDATIONS,
            tagline = "The Open Source Awakening",
            whatGoogleDid = "Google introduced the world to an open-source alternative to Apple's iOS and Symbian. Having acquired Android Inc. in 2005 (founded by Andy Rubin, Rich Miner, Nick Sears, and Chris White), Google rallied 34 tech leaders into the Open Handset Alliance. Google integrated Gmail, Google Maps, and YouTube natively into a mobile operating system, pioneering the pull-down notification shade and home screen widgets.",
            keyFeatures = listOf(
                FeatureHighlight("Android Market", "The premier application storefront allowing third-party app installations without carrier approval.", "Platform"),
                FeatureHighlight("Notification Shade", "The iconic swipe-down curtain for consolidated system notifications, copied later across the entire mobile industry.", "UI"),
                FeatureHighlight("Home Screen Widgets", "Interactive, resizable live widgets directly on home screen workspaces.", "UI"),
                FeatureHighlight("Google Suite Integration", "Instant sync with Google Contacts, Gmail, and early Google Maps with Street View.", "Cloud")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("HTC Dream / T-Mobile G1", "HTC / T-Mobile", 2008, "First Ever Android Phone", "Featured a slide-out 5-row QWERTY keyboard, trackball navigation, and a signature angled bottom chin.")
            ),
            architectureLeap = "Built on Linux 2.6 kernel with Dalvik Virtual Machine executing Dex bytecode optimized for constrained mobile hardware.",
            easterEgg = EasterEggInfo("No Easter Egg Yet", "Settings > About phone", "Android 1.0 had no formal easter egg, but secret dialer codes triggered diagnostic mode.", EasterEggType.ZOMBIE_ART),
            accentColorHex = 0xFF78909C
        ),
        AndroidRelease(
            id = "android_1_1",
            versionName = "1.1",
            dessertName = "Petit Four / Banana Bread",
            internalCodename = "Banana Bread",
            apiLevel = 2,
            releaseDate = "February 9, 2009",
            year = 2009,
            era = AndroidEra.EARLY_FOUNDATIONS,
            tagline = "The First Wireless Update",
            whatGoogleDid = "Proved that an operating system could be updated Over-The-Air (OTA) without requiring a desktop tether or carrier service shop visit. Google introduced Google Voice Search, in-call dialpad hiding, and the ability to save email attachments directly to storage.",
            keyFeatures = listOf(
                FeatureHighlight("Over-The-Air (OTA) Updates", "Commercial proof-of-concept for seamless wireless firmware delivery to consumers.", "System"),
                FeatureHighlight("Voice Search Integration", "Early speech-to-text allowing users to dictate search queries into Google.", "Search"),
                FeatureHighlight("Email Attachment Download", "Saving files and pictures directly onto external microSD cards.", "Storage")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("HTC Magic (Google Ion)", "HTC / Vodafone", 2009, "Pure Touch Milestone", "Eliminated the physical keyboard to experiment with a capacitive-only form factor.")
            ),
            architectureLeap = "Enhanced Over-the-Air recovery flashing system with cryptographic signature verification.",
            easterEgg = EasterEggInfo("Secret Build Strings", "Settings > About Phone", "Early firmware builds revealed internal dessert codename 'Petit Four'.", EasterEggType.ZOMBIE_ART),
            accentColorHex = 0xFF8D6E63
        ),
        AndroidRelease(
            id = "android_1_5",
            versionName = "1.5",
            dessertName = "Cupcake",
            internalCodename = "Cupcake",
            apiLevel = 3,
            releaseDate = "April 27, 2009",
            year = 2009,
            era = AndroidEra.EARLY_FOUNDATIONS,
            tagline = "The First Named Sweet & Virtual Keyboard",
            whatGoogleDid = "Began the legendary tradition of naming releases alphabetically after sweet desserts. Google integrated an on-screen touch keyboard with predictive text, breaking Android's reliance on physical keyboards and opening the door for sleek slate-style smartphones. Google also added camcorder video recording and direct upload to YouTube.",
            keyFeatures = listOf(
                FeatureHighlight("On-Screen Soft Keyboard", "Virtual keyboard with auto-complete and third-party IME keyboard support.", "Input"),
                FeatureHighlight("Video Recording & Playback", "MPEG-4 and 3GP video capture with direct upload to YouTube.", "Media"),
                FeatureHighlight("Live Folder & App Widgets", "Third-party developers could build interactive widgets for user home screens.", "UI"),
                FeatureHighlight("Bluetooth A2DP & AVRCP", "Stereo wireless music streaming and headphone playback control.", "Connectivity")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("HTC Hero", "HTC", 2009, "First 3.5mm Jack & Multitouch", "Popularized capacitive multi-touch screens and introduced HTC Sense UI on top of Android.")
            ),
            architectureLeap = "Introduced the Android NDK (Native Development Kit) r1, permitting developers to compile C/C++ libraries for performance-critical tasks.",
            easterEgg = EasterEggInfo("Cupcake Era Identity", "About Phone", "The birth of giant dessert lawn statues outside Building 44 in Mountain View, California.", EasterEggType.ZOMBIE_ART),
            accentColorHex = 0xFFF48FB1
        ),
        AndroidRelease(
            id = "android_1_6",
            versionName = "1.6",
            dessertName = "Donut",
            internalCodename = "Donut",
            apiLevel = 4,
            releaseDate = "September 15, 2009",
            year = 2009,
            era = AndroidEra.EARLY_FOUNDATIONS,
            tagline = "Universal Search & Diverse Screen Sizes",
            whatGoogleDid = "Engineered Android to run on any screen resolution from low-cost QVGA to high-density WVGA, and added CDMA network compatibility. This move allowed Verizon and Sprint in the USA to adopt Android, sparking massive carrier adoption and ending AT&T's exclusive grip on the modern smartphone market.",
            keyFeatures = listOf(
                FeatureHighlight("Quick Search Box", "Unified search bar querying both web and local device contacts, history, and apps.", "Search"),
                FeatureHighlight("Multi-Resolution Engine", "Independent display density metrics (ldpi, mdpi, hdpi) allowing fluid responsive design.", "Framework"),
                FeatureHighlight("Text-to-Speech Engine (Pico)", "Multilingual synthetic voice speech synthesis for accessibility and navigation.", "AI/Voice"),
                FeatureHighlight("Revamped Android Market", "Categorized apps, customer star reviews, and featured application banners.", "Store")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Motorola CLIQ / Dext", "Motorola", 2009, "Motorola's Pivot", "Motorola staked its entire survival on Android with this social-first device.")
            ),
            architectureLeap = "Density-independent pixel (dp) coordinate system decoupling physical display hardware from software layout rendering.",
            easterEgg = EasterEggInfo("Donut Law Sculpture", "Googleplex Building 44", "A massive glazed fiberglass donut sculpture erected on the Google headquarters lawn.", EasterEggType.ZOMBIE_ART),
            accentColorHex = 0xFFFFB74D
        ),
        AndroidRelease(
            id = "android_2_0",
            versionName = "2.0 – 2.1",
            dessertName = "Eclair",
            internalCodename = "Eclair",
            apiLevel = 7,
            releaseDate = "October 26, 2009",
            year = 2009,
            era = AndroidEra.EARLY_FOUNDATIONS,
            tagline = "Free Voice Navigation & Nexus Debut",
            whatGoogleDid = "Delivered a lethal blow to standalone GPS navigation systems ($500 Garmin/TomTom units) by bundling Google Maps Navigation with free turn-by-turn voice directions. Google also partnered with Motorola for the historic 'Droid Does' Super Bowl ad campaign, and unveiled the Nexus One, selling an unbranded 'Pure Google' flagship online directly to consumers.",
            keyFeatures = listOf(
                FeatureHighlight("Google Maps Navigation", "Free turn-by-turn spoken guidance, live traffic rerouting, and satellite view.", "Maps"),
                FeatureHighlight("Live Interactive Wallpapers", "Dynamic animated home screen backgrounds that reacted to touch and music.", "UI"),
                FeatureHighlight("Multi-Touch & Pinch-to-Zoom", "Native multi-touch gestures across browser, maps, and gallery.", "Interaction"),
                FeatureHighlight("HTML5 Mobile Browser", "Web standards support with video tag, geolocation, and hardware canvas.", "Web")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Motorola DROID", "Motorola / Verizon", 2009, "The iPhone Killer", "The seminal ad blitz 'iDon't... Droid Does'. High-res 854x480 screen and gold-standard keyboard."),
                HardwareMilestoneRef("Nexus One", "Google / HTC", 2010, "Google's First Direct Phone", "1GHz Snapdragon QSD8250, glowing trackball notification light, dual noise-cancelling mics.")
            ),
            architectureLeap = "OpenGL ES 2.0 3D hardware graphics pipeline and multi-account sync framework for corporate Microsoft Exchange.",
            easterEgg = EasterEggInfo("Secret Diagnostics", "*#*#INFO#*#*", "Secret testing dialer menus and Google Earth 3D fly-overs.", EasterEggType.ZOMBIE_ART),
            accentColorHex = 0xFFFFCC80
        ),
        AndroidRelease(
            id = "android_2_2",
            versionName = "2.2",
            dessertName = "Froyo",
            internalCodename = "Frozen Yogurt",
            apiLevel = 8,
            releaseDate = "May 20, 2010",
            year = 2010,
            era = AndroidEra.EARLY_FOUNDATIONS,
            tagline = "The JIT Speed Demon & Wi-Fi Hotspots",
            whatGoogleDid = "Re-engineered Dalvik with a Just-In-Time (JIT) compiler that yielded a massive 2x to 5x CPU speed increase in benchmark tests. Google championed the open web by integrating Adobe Flash Player 10.1 support (challenging Steve Jobs' Flash ban), introduced portable Wi-Fi tethering hotspots, and launched Cloud-to-Device Messaging (C2DM).",
            keyFeatures = listOf(
                FeatureHighlight("Dalvik JIT Compiler", "Dynamic compilation turning interpreted bytecode into native machine instructions on the fly.", "Performance"),
                FeatureHighlight("Wi-Fi Hotspot & Tethering", "Turn your Android smartphone into a portable broadband modem for laptops and tablets.", "Networking"),
                FeatureHighlight("C2DM Push Notifications", "Early push notification cloud architecture for real-time messaging apps.", "Cloud"),
                FeatureHighlight("Install Apps to SD Card", "Apps2SD allowed budget devices with small internal memory to offload large APKs.", "Storage")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("HTC Desire / EVO 4G", "HTC / Sprint", 2010, "First WiMAX 4G Phone", "Massive 4.3-inch screen, kickstand, and the first marketed '4G' mobile phone in the US.")
            ),
            architectureLeap = "Dalvik JIT compilation architecture and V8 high-speed JavaScript engine inside the browser.",
            easterEgg = EasterEggInfo("Froyo Speed Tests", "Linpack Benchmark", "Developers celebrated hitting over 40 MFLOPS on hardware that scored 8 MFLOPS on Eclair.", EasterEggType.ZOMBIE_ART),
            accentColorHex = 0xFF81D4FA
        ),
        AndroidRelease(
            id = "android_2_3",
            versionName = "2.3",
            dessertName = "Gingerbread",
            internalCodename = "Gingerbread",
            apiLevel = 9,
            releaseDate = "December 6, 2010",
            year = 2010,
            era = AndroidEra.EARLY_FOUNDATIONS,
            tagline = "NFC, Gaming APIs, & The First Easter Egg",
            whatGoogleDid = "Partnered with Samsung to produce the curved-glass Nexus S, introducing Near Field Communication (NFC) hardware to smartphones. Google tuned Android for high-performance mobile gaming with concurrent garbage collection and audio mixing, added native front-facing camera video calling, and hid the very first hidden Easter Egg inside the OS.",
            keyFeatures = listOf(
                FeatureHighlight("Near Field Communication (NFC)", "Contactless payment precursors and wireless tag reading.", "Hardware"),
                FeatureHighlight("Concurrent Garbage Collection", "Minimized UI stutter and frame drops by eliminating GC pause times in Dalvik.", "Performance"),
                FeatureHighlight("Download Manager & Sensors", "System-wide background file downloader and gyroscope sensor integration.", "System"),
                FeatureHighlight("One-Touch Text Selection", "Press-and-hold bounding box handles for effortless word copy-paste.", "Input")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Nexus S", "Google / Samsung", 2010, "First NFC Smartphone", "Super AMOLED Contour curved display, NFC chip, and native Google Gingerbread experience.")
            ),
            architectureLeap = "Concurrent low-pause Dalvik Garbage Collector and native sensory HAL for gyroscopes and barometers.",
            easterEgg = EasterEggInfo("Zombie Art (First Ever!)", "Settings > About Phone > Tap 'Android version' rapidly", "Hand-painted artwork by Jack Larson depicting the green Bugdroid standing next to an undead zombie eating gingerbread.", EasterEggType.ZOMBIE_ART),
            accentColorHex = 0xFF8D6E63
        ),
        AndroidRelease(
            id = "android_3_0",
            versionName = "3.0 – 3.2",
            dessertName = "Honeycomb",
            internalCodename = "Honeycomb",
            apiLevel = 11,
            releaseDate = "February 22, 2011",
            year = 2011,
            era = AndroidEra.HOLO_REVOLUTION,
            tagline = "The Tablet Odyssey & Holo UI",
            whatGoogleDid = "Hired webOS design visionary Matías Duarte to lead Android design. Duarte reimagined Android from scratch for large tablet screens with the futuristic, sci-fi Tron-inspired 'Holo' theme. Honeycomb banished physical hardware buttons in favor of on-screen soft keys (Back, Home, Recents), invented the Action Bar, and introduced Fragments for adaptive multi-pane interfaces.",
            keyFeatures = listOf(
                FeatureHighlight("Virtual System Navigation", "Eliminated capacitive hardware buttons with on-screen Back, Home, and Recents.", "UI"),
                FeatureHighlight("The Holographic 'Holo' Theme", "Dark background with electric neon cyan accents, wireframes, and hexagonal widgets.", "Design"),
                FeatureHighlight("Fragments API", "Building adaptive modular UIs showing list-detail columns side-by-side on tablets.", "Framework"),
                FeatureHighlight("Hardware UI Acceleration", "2D rendering pipeline fully offloaded to GPU for silky smooth scroll physics.", "Graphics")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Motorola XOOM", "Motorola", 2011, "First Dual-Core Tablet", "10.1-inch 1280x800 display, Nvidia Tegra 2 dual-core processor, Honeycomb launch pad.")
            ),
            architectureLeap = "Fully hardware-accelerated 2D rendering pipeline and Renderscript 3D computation framework.",
            easterEgg = EasterEggInfo("Tron Neon Bee", "Settings > About Phone > Tap Android version", "A glowing electric blue bee with a 'REZZZZZZ' speech bubble paying homage to Tron.", EasterEggType.NYANDROID),
            accentColorHex = 0xFF00E5FF
        ),
        AndroidRelease(
            id = "android_4_0",
            versionName = "4.0",
            dessertName = "Ice Cream Sandwich",
            internalCodename = "Ice Cream Sandwich",
            apiLevel = 14,
            releaseDate = "October 19, 2011",
            year = 2011,
            era = AndroidEra.HOLO_REVOLUTION,
            tagline = "Unified Phones & Tablets with Roboto",
            whatGoogleDid = "Unified the split phone and tablet codebases into a single cohesive platform. Google commissioned Christian Robertson to design the Roboto typeface specifically for high-DPI smartphone displays. Launched the Galaxy Nexus with zero physical face buttons, pioneered swipe-to-dismiss notifications, Android Beam NFC transfers, and futuristic Face Unlock.",
            keyFeatures = listOf(
                FeatureHighlight("Roboto Typography", "Clean modern geometric neo-grotesque font engineered for digital clarity.", "Design"),
                FeatureHighlight("Swipe-to-Dismiss Gestures", "Flick away individual notifications and recent apps with a single swipe.", "Interaction"),
                FeatureHighlight("Android Beam", "Tap two phones back-to-back using NFC to beam contacts, maps, and YouTube videos.", "Sharing"),
                FeatureHighlight("Data Usage Tracker", "Detailed app data breakdown with user-definable hard limits and warning thresholds.", "Networking")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Galaxy Nexus", "Google / Samsung", 2011, "The First Buttonless Phone", "4.65-inch 720p HD Super AMOLED, curved hyper-skin back, zero physical front buttons.")
            ),
            architectureLeap = "Single unified Android framework for all form factors; hardware-accelerated Holo UI default for all targetSdk 14+ apps.",
            easterEgg = EasterEggInfo("Nyandroid Pixel Mascot", "Settings > About phone > Tap version", "A flying pixelated 8-bit Ice Cream Sandwich bugdroid soaring through deep space like Nyan Cat.", EasterEggType.NYANDROID),
            accentColorHex = 0xFF80DEEA
        ),
        AndroidRelease(
            id = "android_4_1",
            versionName = "4.1 – 4.3",
            dessertName = "Jelly Bean",
            internalCodename = "Jelly Bean",
            apiLevel = 16,
            releaseDate = "July 9, 2012",
            year = 2012,
            era = AndroidEra.HOLO_REVOLUTION,
            tagline = "Project Butter (60 FPS) & Google Now",
            whatGoogleDid = "Launched 'Project Butter', a concentrated engineering effort implementing triple buffering and VSYNC timing to lock UI rendering at a buttery smooth 60 frames per second. Google also shocked the industry with Google Now—a predictive assistant that anticipated what you needed before you asked (boarding passes, commute times, parcel deliveries). Google teamed with ASUS to release the $199 Nexus 7 tablet, dominating affordable mobile computing.",
            keyFeatures = listOf(
                FeatureHighlight("Project Butter (60 FPS)", "VSYNC timing synchronization, triple graphics buffering, and touch anticipation.", "Performance"),
                FeatureHighlight("Google Now Cards", "Predictive smart assistant cards based on Gmail, search queries, and location telemetry.", "AI/Assistant"),
                FeatureHighlight("Rich Expandable Notifications", "Two-finger expansion to view photo previews, reply inline, or play/pause audio.", "UI"),
                FeatureHighlight("Multi-User Accounts & BLE", "Restricted user profiles on tablets and Bluetooth Low Energy (Smart) in 4.3.", "System")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Nexus 7 (2012/2013)", "Google / ASUS", 2012, "The $199 Tablet King", "Demolished the tablet market with Nvidia Tegra 3 quad-core performance at half the iPad's price."),
                HardwareMilestoneRef("Nexus 4", "Google / LG", 2012, "Crystal Reflection Glass", "Sold for $299 unlocked with Snapdragon S4 Pro, 2GB RAM, and holographic glass back.")
            ),
            architectureLeap = "Project Butter graphics synchronization pipeline; Choreographer event loop aligning redraw with display refresh cycles.",
            easterEgg = EasterEggInfo("Floating Jelly Beans", "Settings > About Phone > Tap version", "A giant smiling red Jelly Bean that bursts into hundreds of colorful interactive floating beans you can fling around the screen.", EasterEggType.JELLY_BEANS),
            accentColorHex = 0xFFE91E63
        ),
        AndroidRelease(
            id = "android_4_4",
            versionName = "4.4",
            dessertName = "KitKat",
            internalCodename = "Key Lime Pie",
            apiLevel = 19,
            releaseDate = "October 31, 2013",
            year = 2013,
            era = AndroidEra.HOLO_REVOLUTION,
            tagline = "Project Svelte (512MB RAM) & 'OK Google'",
            whatGoogleDid = "Partnered with Nestlé for a viral sweet-treat crossover (renaming 'Key Lime Pie' to KitKat). Executed 'Project Svelte' to optimize Android's memory footprint so aggressively that it could run smoothly on entry-level 512MB RAM phones, bringing billions of emerging market users online. Google launched the cult-favorite Nexus 5 and previewed the experimental new ART runtime.",
            keyFeatures = listOf(
                FeatureHighlight("Project Svelte (512MB RAM)", "Trimmed OS memory consumption to bring smooth performance to entry-level devices.", "Optimization"),
                FeatureHighlight("Always-Listening 'OK Google'", "Voice hotword detection waking the phone hands-free from the home screen.", "Voice/AI"),
                FeatureHighlight("Full-Screen Immersive Mode", "Auto-hiding status bar and navigation keys for true edge-to-edge gaming and reading.", "UI"),
                FeatureHighlight("Storage Access Framework", "Unified system picker for browsing local files, Google Drive, and cloud storage.", "Storage")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Nexus 5", "Google / LG", 2013, "The Cult Classic", "Snapdragon 800, 5.0-inch 1080p IPS display, wireless Qi charging, and tactile ceramic buttons for $349.")
            ),
            architectureLeap = "Introduced optional developer preview of ART (Android Runtime) with Ahead-of-Time (AOT) compilation; zRAM memory compression.",
            easterEgg = EasterEggInfo("Spinning K Logo & Dessert Mosaic", "Settings > About Phone > Tap version", "A rotating KitKat-style bold 'K' that launches an Android logo followed by an interactive Windows-style mosaic of past dessert icons.", EasterEggType.SPINNING_K),
            accentColorHex = 0xFFD32F2F
        ),
        AndroidRelease(
            id = "android_5_0",
            versionName = "5.0 – 5.1",
            dessertName = "Lollipop",
            internalCodename = "Lemon Meringue Pie",
            apiLevel = 21,
            releaseDate = "November 12, 2014",
            year = 2014,
            era = AndroidEra.MATERIAL_DESIGN,
            tagline = "The Material Design Revolution & ART",
            whatGoogleDid = "The biggest visual and architectural transformation in Android history. Matías Duarte unveiled 'Material Design'—a comprehensive design language rooted in tactile paper sheets, realistic light, elevation shadow physics, and energetic ripple feedback. Google permanently banished Dalvik, switching to the 64-bit Android Runtime (ART), launched Project Volta for battery stamina, and expanded Android to watches (Wear OS), cars (Android Auto), and TVs.",
            keyFeatures = listOf(
                FeatureHighlight("Material Design System", "Z-axis elevation, real-time drop shadows, dynamic color palettes, and touch ripples.", "Design"),
                FeatureHighlight("Android Runtime (ART) Default", "Ahead-of-Time (AOT) native code compilation replacing Dalvik for massive app speed boosts.", "Architecture"),
                FeatureHighlight("Lock Screen Notifications", "Interactive card-based notifications accessible directly without unlocking.", "UI"),
                FeatureHighlight("Project Volta & Battery Saver", "System JobScheduler batching network tasks and smart battery-saver mode.", "Battery"),
                FeatureHighlight("64-Bit CPU Support", "Native ARM64 architecture support enabling desktop-class computational power.", "System")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Nexus 6", "Google / Motorola", 2014, "The Giant Shamu", "6.0-inch Quad HD AMOLED display, dual front-facing stereo speakers, and Turbo Charging."),
                HardwareMilestoneRef("Nexus 9", "Google / HTC", 2014, "First 64-Bit Android", "Nvidia Tegra K1 64-bit Denver dual-core processor with Kepler GPU.")
            ),
            architectureLeap = "Full replacement of Dalvik by Ahead-of-Time (AOT) compiled ART runtime; JobScheduler API; Camera2 HAL.",
            easterEgg = EasterEggInfo("Flappy Droid (Lollipop)", "Settings > About Phone > Tap version", "A brutally difficult clone of Flappy Bird where you tap to guide a Bugdroid through giant spinning candy lollipops.", EasterEggType.LOLLIPOP_FLAPPY),
            accentColorHex = 0xFFFF5722
        ),
        AndroidRelease(
            id = "android_6_0",
            versionName = "6.0",
            dessertName = "Marshmallow",
            internalCodename = "Macadamia Nut Cookie",
            apiLevel = 23,
            releaseDate = "October 5, 2015",
            year = 2015,
            era = AndroidEra.MATERIAL_DESIGN,
            tagline = "Runtime Permissions, Doze Mode, & USB-C",
            whatGoogleDid = "Addressed long-standing user privacy and battery complaints. Google scrapped the dreaded install-time permission dialog, forcing apps to ask for camera, microphone, or location permissions only when needed at runtime. Introduced 'Doze Mode'—deep sleep standby states using accelerometer sensors when the phone sat flat. Launched the final two Nexus phones (Nexus 6P and 5X), inaugurating the reversible USB-C standard.",
            keyFeatures = listOf(
                FeatureHighlight("Granular Runtime Permissions", "Apps must request sensitive permissions (Location, Mic, Camera) on-demand.", "Privacy"),
                FeatureHighlight("Doze Mode & App Standby", "Exponential battery life extension by suspending background sync when device is stationary.", "Battery"),
                FeatureHighlight("Nexus Imprint (Fingerprint API)", "Native standardized biometric fingerprint authentication across the platform.", "Security"),
                FeatureHighlight("USB-C Standard Support", "Native fast charging and reversible USB Type-C hardware integration.", "Hardware"),
                FeatureHighlight("Google Now on Tap", "Contextual assistant parsing on-screen text with a single long-press of Home.", "AI")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Nexus 6P", "Google / Huawei", 2015, "The Ultimate Nexus", "All-metal unibody, iconic camera visor glass, 5.7-inch Quad HD AMOLED, and Nexus Imprint."),
                HardwareMilestoneRef("Nexus 5X", "Google / LG", 2015, "The Compact Nexus", "Affordable lightweight polycarbonate companion with matching high-end 12.3MP camera.")
            ),
            architectureLeap = "Standardized Biometric Fingerprint HAL; Doze maintenance windows in AlarmManager; Direct Share intents.",
            easterEgg = EasterEggInfo("Marshmallow Flappy Droid", "Settings > About Phone > Tap version", "Multiplayer version of Flappy Droid supporting up to 6 players simultaneously jumping through marshmallows.", EasterEggType.MARSHMALLOW_FLAPPY),
            accentColorHex = 0xFF9C27B0
        ),
        AndroidRelease(
            id = "android_7_0",
            versionName = "7.0 – 7.1",
            dessertName = "Nougat",
            internalCodename = "New York Cheesecake",
            apiLevel = 24,
            releaseDate = "August 22, 2016",
            year = 2016,
            era = AndroidEra.MATERIAL_DESIGN,
            tagline = "The Birth of Pixel & Split-Screen Multitasking",
            whatGoogleDid = "Retired the legendary Nexus brand after 7 years and launched 'Made by Google' with the original Google Pixel and Pixel XL. Google integrated native split-screen multi-window support, Vulkan 3D graphics API, and JIT+AOT hybrid compilation. Nougat also premiered seamless background A/B system partition updates and introduced the conversational Google Assistant.",
            keyFeatures = listOf(
                FeatureHighlight("Native Split-Screen Multitasking", "Run two applications side-by-side on phones and tablets with adjustable split dividers.", "Productivity"),
                FeatureHighlight("Google Assistant Debut", "Conversational AI replacing Google Now, initially exclusive to the Pixel.", "AI/Assistant"),
                FeatureHighlight("Seamless A/B System Updates", "Install OS updates silently in the background on a dual system partition; reboot in seconds.", "System"),
                FeatureHighlight("Vulkan 3D Graphics API", "Low-overhead direct GPU access for console-quality mobile gaming visuals.", "Graphics"),
                FeatureHighlight("Quick Reply & Bundled Alerts", "Reply to messages directly from notifications; bundled per-app notification stacks.", "UI")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel & Pixel XL", "Google / HTC (Contract)", 2016, "The 'Made by Google' Era", "Highest-rated DxOMark mobile camera, glass-and-aluminum two-tone back, unlimited original-quality Google Photos.")
            ),
            architectureLeap = "Hybrid JIT/AOT ART compiler with profile-guided optimization (PGO); dual A/B partition streaming updates.",
            easterEgg = EasterEggInfo("Android Neko (Cat Collector)", "Quick Settings edit > Add '???? Dish'", "A virtual cat collector minigame inspired by Neko Atsume where you leave treats (Bits, Fish, Chicken) on a plate in Quick Settings.", EasterEggType.NOUGAT_CAT),
            accentColorHex = 0xFF009688
        ),
        AndroidRelease(
            id = "android_8_0",
            versionName = "8.0 – 8.1",
            dessertName = "Oreo",
            internalCodename = "Oatmeal Cookie",
            apiLevel = 26,
            releaseDate = "August 21, 2017",
            year = 2017,
            era = AndroidEra.TREBLE_AND_AI,
            tagline = "Project Treble & Computational Photography",
            whatGoogleDid = "Executed 'Project Treble', the greatest architectural overhaul in Android history. Treble separated the Android OS framework from vendor hardware drivers via a Vendor Interface (VINTF), allowing OEMs to update Android without waiting for chipmaker silicon drivers. Google launched the Pixel 2, redefining mobile photography through pure software algorithms and the custom Pixel Visual Core coprocessor.",
            keyFeatures = listOf(
                FeatureHighlight("Project Treble Architecture", "Decoupled Android OS from vendor silicon HALs to fix software update fragmentation forever.", "Architecture"),
                FeatureHighlight("Notification Channels & Dots", "Categorized notifications per app with granular alert controls and app icon badges.", "Notifications"),
                FeatureHighlight("Picture-in-Picture (PiP)", "Watch YouTube, Maps, or video calls in a floating resizable window over other apps.", "Multitasking"),
                FeatureHighlight("Autofill Framework", "System-level password and credit card autofill for password managers like 1Password and Bitwarden.", "Security"),
                FeatureHighlight("Adaptive Launcher Icons", "Adaptive masks allowing home screens to render all app icons uniformly as circles, squares, or squircles.", "Design")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel 2 & 2 XL", "Google / HTC & LG", 2017, "Computational Photography King", "Single-lens portrait mode outperforming dual-camera competitors; Active Edge squeezable sides; Pixel Visual Core.")
            ),
            architectureLeap = "Project Treble Vendor Interface (HIDL); boundary decoupling system.img from vendor.img partitions.",
            easterEgg = EasterEggInfo("Floating Deep-Sea Octopus", "Settings > Tap Android version > Hold cookie", "A floating black octopus floating in an ocean abyss that you can drag around with realistic physics.", EasterEggType.OREO_COOKIE),
            accentColorHex = 0xFFFFC107
        ),
        AndroidRelease(
            id = "android_9_0",
            versionName = "9",
            dessertName = "Pie",
            internalCodename = "Pistachio Ice Cream",
            apiLevel = 28,
            releaseDate = "August 6, 2018",
            year = 2018,
            era = AndroidEra.TREBLE_AND_AI,
            tagline = "Digital Wellbeing & On-Device Machine Learning",
            whatGoogleDid = "Pioneered the 'Digital Wellbeing' movement, helping users monitor app screen time, set app timers, and Wind Down to grayscale at night. Android embraced on-device machine learning with Adaptive Battery (DeepMind collaboration) and Adaptive Brightness. Google introduced pill-based swipe gesture navigation, display notch cutouts, and unveiled 'Night Sight' on the Pixel 3, turning pitch darkness into daylight.",
            keyFeatures = listOf(
                FeatureHighlight("Digital Wellbeing Dashboard", "Track daily screen time, app unlocks, notifications received, and enforce app timers.", "Wellness"),
                FeatureHighlight("Adaptive Battery & Brightness", "On-device AI prioritizing CPU cycles for frequently used apps; learning personal backlight habits.", "AI/Battery"),
                FeatureHighlight("Pill Gesture Navigation", "Swipe-up pill gesture replacing the traditional 3-button navigation bar.", "Navigation"),
                FeatureHighlight("Display Cutout / Notch API", "Native support for teardrop notches, punch-holes, and edge-to-edge camera cutouts.", "Display"),
                FeatureHighlight("App Actions & Slices", "Predictive app shortcuts predicting user intent right inside the app drawer.", "Search")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel 3 & 3 XL", "Google / Foxconn", 2018, "The Night Sight Miracle", "Night Sight astrophotography; Top Shot burst selector; dual front ultrawide selfie cameras; Call Screen.")
            ),
            architectureLeap = "Neural Networks API (NNAPI) 1.1 hardware acceleration for on-device machine learning models.",
            easterEgg = EasterEggInfo("Retro Neon Paint App", "Settings > About Phone > Tap 'P' > Tap Paint", "A psychedelic rainbow paint canvas app with variable stroke widths and pressure sensitivity.", EasterEggType.PIE_PAINT),
            accentColorHex = 0xFFAB47BC
        ),
        AndroidRelease(
            id = "android_10_0",
            versionName = "10",
            dessertName = "Quince Tart (Internal)",
            internalCodename = "Queen Cake / Quince Tart",
            apiLevel = 29,
            releaseDate = "September 3, 2019",
            year = 2019,
            era = AndroidEra.TREBLE_AND_AI,
            tagline = "The Modern Rebrand, Dark Theme, & Project Mainline",
            whatGoogleDid = "Google dropped public dessert branding to adopt global number naming, unveiling a modernized Android logo. Android 10 brought system-wide Dark Theme, full edge swipe-to-back gesture navigation, and Scoped Storage privacy protection. Crucially, Google launched 'Project Mainline'—allowing critical OS components (media codecs, privacy modules) to be updated via Google Play System Updates without requiring full firmware downloads.",
            keyFeatures = listOf(
                FeatureHighlight("System-Wide Dark Theme", "OLED battery saver turning entire OS and supported third-party apps to true black.", "Theme"),
                FeatureHighlight("Full Edge Gesture Navigation", "Swipe inward from left or right screen edge to go Back; swipe up for Home and Recents.", "Navigation"),
                FeatureHighlight("Project Mainline (Modular Updates)", "Deliver security and core OS updates directly through Google Play background updates.", "System"),
                FeatureHighlight("Scoped Storage Privacy", "Restricted app access to files; apps can only view their own isolated storage compartments.", "Privacy"),
                FeatureHighlight("Live Caption", "On-device realtime captions generated for any video, podcast, or audio message offline.", "Accessibility")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel 4 & 4 XL", "Google", 2019, "Project Soli Radar & 90Hz", "Motion Sense radar gestures, secure 3D Face Unlock, 90Hz Smooth Display, and Astrophotography mode.")
            ),
            architectureLeap = "Project Mainline APEX container packages updated independently through Google Play Store services.",
            easterEgg = EasterEggInfo("Android 10 Nonogram Puzzle", "Settings > Tap Android 10 > Arrange '1' and '0' into 'Q'", "A grid-based Nonogram / Picross puzzle game drawing classic Android icons.", EasterEggType.ANDROID_10_PUZZLE),
            accentColorHex = 0xFF26A69A
        ),
        AndroidRelease(
            id = "android_11_0",
            versionName = "11",
            dessertName = "Red Velvet Cake",
            internalCodename = "Red Velvet Cake",
            apiLevel = 30,
            releaseDate = "September 8, 2020",
            year = 2020,
            era = AndroidEra.TREBLE_AND_AI,
            tagline = "People, Controls, & Privacy",
            whatGoogleDid = "Centered the operating system around three pillars: People, Controls, and Privacy. Android 11 grouped all messaging notifications into a dedicated 'Conversations' shade section, introduced floating Chat Bubbles, transformed the Power Menu into an IoT smart home dashboard, and added one-time temporary permissions and automatic permission revocation for abandoned apps.",
            keyFeatures = listOf(
                FeatureHighlight("Dedicated Conversations Shade", "Prioritized messaging section at top of notifications with priority sender badges.", "Social"),
                FeatureHighlight("Floating Chat Bubbles", "Keep active conversations floating on screen while using any other application.", "Multitasking"),
                FeatureHighlight("Smart Device Power Menu", "Long-press power button to reveal Google Home smart lighting and thermostat controls.", "IoT"),
                FeatureHighlight("One-Time Permissions & Auto-Reset", "Grant mic or camera access for single session only; permissions auto-reset if unused.", "Privacy"),
                FeatureHighlight("Built-In Screen Recorder", "Native screen capture with mic commentary and device audio recording without third-party apps.", "Media")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel 5", "Google", 2020, "The Clean 5G Pioneer", "Recycled bio-resin aluminum casing, reverse wireless charging, 90Hz OLED, and symmetrical bezels.")
            ),
            architectureLeap = "Scoped storage mandatory enforcement; 5G state detection APIs and Dynamic Bandwidth Metering.",
            easterEgg = EasterEggInfo("Cat Neko Dial 11", "Settings > Tap Android 11 > Turn dial to 11", "A rotary volume dial that clicks past 10 to 11, spawning a tiny cat emoji to resurrect the Android Neko feeding game in the power controls.", EasterEggType.ANDROID_11_VOLUME),
            accentColorHex = 0xFFE57373
        ),
        AndroidRelease(
            id = "android_12_0",
            versionName = "12 & 12L",
            dessertName = "Snow Cone",
            internalCodename = "Snow Cone",
            apiLevel = 31,
            releaseDate = "October 19, 2021",
            year = 2021,
            era = AndroidEra.MATERIAL_YOU,
            tagline = "Material You, Google Tensor, & 12L Foldables",
            whatGoogleDid = "Unveiled 'Material You' (Material Design 3), the most expressive personalized visual identity in Android history. Material You dynamically extracted an entire harmonious color palette from the user's personal wallpaper. Google shipped the Pixel 6 with its first custom-designed silicon, the Google Tensor chip. With Android 12L, Google re-architected Android for foldables and tablets with dual-pane shades and persistent taskbars.",
            keyFeatures = listOf(
                FeatureHighlight("Material You (Dynamic Color)", "Monet extraction engine generating unified color schemes from your chosen wallpaper.", "Design"),
                FeatureHighlight("Privacy Dashboard & Sensor Toggles", "24-hour timeline of mic/camera/location access; instant Quick Settings hardware kill toggles.", "Privacy"),
                FeatureHighlight("Microphone & Camera Green Dots", "Real-time status bar green indicators whenever apps access the microphone or camera.", "Security"),
                FeatureHighlight("Android 12L Foldable Optimization", "Persistent multitasking taskbar, dual-column notification shade, and letterboxing fixes for tablets.", "Large Screen"),
                FeatureHighlight("Scrolling Screenshots", "Capture entire web pages and chat logs in a single continuous stitched screenshot.", "Productivity")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel 6 & 6 Pro", "Google", 2021, "The Custom Tensor Era", "Custom Google Tensor silicon, 50MP camera sensor, distinctive horizontal visor, Real Tone photography.")
            ),
            architectureLeap = "Monet color extraction algorithm in SystemUI; Core OS performance optimizations reducing CPU time for core system services by 22%.",
            easterEgg = EasterEggInfo("Analog Clock Widget", "Settings > About Phone > Tap Android 12", "An analog clock widget where turning both hands to 12:00 bursts into a display of dynamic Material You color bubbles.", EasterEggType.ANDROID_12_CLOCK),
            accentColorHex = 0xFF5C6BC0
        ),
        AndroidRelease(
            id = "android_13_0",
            versionName = "13",
            dessertName = "Tiramisu",
            internalCodename = "Tiramisu",
            apiLevel = 33,
            releaseDate = "August 15, 2022",
            year = 2022,
            era = AndroidEra.MATERIAL_YOU,
            tagline = "Notification Permissions & Per-App Languages",
            whatGoogleDid = "Refined Material You by opening themed icons to third-party apps and introducing the media player squiggly playback line. Ended notification spam by requiring apps to request explicit permission before posting notifications (`POST_NOTIFICATIONS`). Launched the zero-permission Android Photo Picker and introduced per-app language settings for multilingual users.",
            keyFeatures = listOf(
                FeatureHighlight("Notification Runtime Permission", "Apps cannot send spam alerts without explicit user consent on first launch.", "Notifications"),
                FeatureHighlight("Zero-Permission Photo Picker", "Select specific photos without granting broad read permissions to your entire gallery.", "Privacy"),
                FeatureHighlight("Per-App Language Preferences", "Assign different languages to individual apps independent of the system display language.", "Localization"),
                FeatureHighlight("Themed Icons Everywhere", "Dynamic color theming expanded to all third-party app icons on the home screen.", "Personalization"),
                FeatureHighlight("Spatial Audio & LE Audio", "Dynamic head tracking for immersive surround sound and Bluetooth LE Audio LC3 codec.", "Audio")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel 7 & 7 Pro", "Google", 2022, "Refined Visor & Tensor G2", "Polished aluminum camera bar, 30x Super Res Zoom, Photo Unblur, and Macro Focus.")
            ),
            architectureLeap = "Standardized Photo Picker intent contracts; Bluetooth Low Energy Audio (LE Audio) stack with Isochronous Channels.",
            easterEgg = EasterEggInfo("Space Bubbles & Emoji Burst", "Settings > Tap 13 > Set clock to 1:00", "Sets off an explosion of colorful Material You bubbles that morph into themes of emojis (monkeys, hearts, planets, flowers).", EasterEggType.ANDROID_13_BUBBLES),
            accentColorHex = 0xFF26C6DA
        ),
        AndroidRelease(
            id = "android_14_0",
            versionName = "14",
            dessertName = "Upside Down Cake",
            internalCodename = "Upside Down Cake",
            apiLevel = 34,
            releaseDate = "October 4, 2023",
            year = 2023,
            era = AndroidEra.MATERIAL_YOU,
            tagline = "Ultra HDR, Lock Screen Clock Customization, & Pixel Fold",
            whatGoogleDid = "Expanded personalization with expressive lock screen clock styles, shortcuts, and monochrome themes. Revolutionized mobile imaging with Ultra HDR—preserving 10-bit HDR highlights inside standard JPEG files backwards-compatible with SDR screens. Google also launched its very first foldable phone, the Pixel Fold, and committed to an unprecedented 7 years of full OS updates on the Pixel 8.",
            keyFeatures = listOf(
                FeatureHighlight("Ultra HDR Photo Format", "10-bit HDR gainmap embedded into standard JPEG files for stunning highlight luminosity.", "Camera/Display"),
                FeatureHighlight("Custom Lock Screen Clocks", "Multiple font styles, weather complications, and custom bottom corner action shortcuts.", "Customization"),
                FeatureHighlight("Predictive Back Animations", "Cross-activity preview animation letting users preview the previous screen before committing to Back.", "Navigation"),
                FeatureHighlight("Credential Manager API", "Unified authentication API handling Passkeys, passwords, and Federated Google Sign-In.", "Security"),
                FeatureHighlight("7 Years of Full OS Updates", "Google set a new mobile longevity benchmark by promising 7 full years of Android OS and security upgrades.", "Support")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel Fold", "Google", 2023, "Google's First Foldable", "Ultra-thin fluid friction hinge, 7.6-inch inner OLED, tabletop mode, and dual-screen camera preview."),
                HardwareMilestoneRef("Google Pixel 8 & 8 Pro", "Google", 2023, "Generative AI Pioneer", "Tensor G3, Best Take, Magic Editor, Audio Magic Eraser, and 7 years of promised updates.")
            ),
            architectureLeap = "Jetpack Credential Manager for Passkey authentication; Gainmap HDR rendering pipeline; 200% non-linear font scaling.",
            easterEgg = EasterEggInfo("Deep Space Rocket Lander", "Settings > About phone > Hold Android 14 logo", "An interactive space flight simulator where you pilot a spacecraft with thrusters and land on celestial bodies in deep space.", EasterEggType.ANDROID_14_ROCKET),
            accentColorHex = 0xFFFF7043
        ),
        AndroidRelease(
            id = "android_15_0",
            versionName = "15",
            dessertName = "Vanilla Ice Cream",
            internalCodename = "Vanilla Ice Cream",
            apiLevel = 35,
            releaseDate = "October 15, 2024",
            year = 2024,
            era = AndroidEra.MATERIAL_YOU,
            tagline = "Private Space, Edge-to-Edge, & Gemini On-Device",
            whatGoogleDid = "Enforced edge-to-edge content rendering across the entire OS, making apps draw behind the status and gesture navigation bars by default. Introduced 'Private Space'—a biometric sandbox completely isolating sensitive banking and personal apps and their notifications. Integrated Gemini Nano with multimodal capabilities directly on-device with the Pixel 9 series, alongside satellite messaging and AI Theft Detection Lock.",
            keyFeatures = listOf(
                FeatureHighlight("Private Space Vault", "Isolated secure profile hiding confidential apps and alerts behind a secondary biometric lock.", "Privacy"),
                FeatureHighlight("Mandatory Edge-to-Edge", "System enforced full-screen layouts drawing under transparent system bars by default.", "UI/UX"),
                FeatureHighlight("Partial Screen Sharing", "Share or record a single application window rather than casting the entire phone screen.", "Productivity"),
                FeatureHighlight("App Archiving in OS", "Free up 60% of storage by archiving rarely used apps while keeping personal user data intact.", "Storage"),
                FeatureHighlight("AI Theft Detection Lock", "Machine learning sensor heuristics locking the phone automatically if snatched from your hand.", "Security")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Google Pixel 9 / 9 Pro / Fold", "Google", 2024, "Gemini Multimodal Silicon", "Tensor G4, Super Actua display, satellite SOS antenna, and Gemini Nano multimodal on-device AI.")
            ),
            architectureLeap = "16KB page size kernel support for faster app launch times and reduced power consumption; Android Dynamic Performance Framework (ADPF).",
            easterEgg = EasterEggInfo("Space Badge & Flag", "Settings > About Phone > Hold 15 logo", "A mission control badge simulator tracking coordinates, thrust, and planting an Android flag on distant planetary surfaces.", EasterEggType.ANDROID_15_SPACE),
            accentColorHex = 0xFF4CAF50
        ),
        AndroidRelease(
            id = "android_16_0",
            versionName = "16 (Roadmap)",
            dessertName = "Baklava",
            internalCodename = "Baklava",
            apiLevel = 36,
            releaseDate = "2025 – 2026",
            year = 2025,
            era = AndroidEra.MATERIAL_YOU,
            tagline = "Faster Cadence, Rich Ongoing Notifications, & Next-Gen AI",
            whatGoogleDid = "Google transitioned Android to an accelerated major release cadence, targeting a Q2 release window to align with summer flagship smartphone launches. Codenamed 'Baklava', Android 16 introduces Live Activities / Rich Ongoing Notifications API for real-time ride and delivery tracking, embedded photo picker inside app flows, and deeper on-device foundation model intelligence.",
            keyFeatures = listOf(
                FeatureHighlight("Accelerated Release Cadence", "Q2 release schedule allowing new devices to launch with latest OS earlier in the year.", "Strategy"),
                FeatureHighlight("Rich Ongoing Notifications", "Live status updates in the status bar and lock screen for rides, delivery, and timers.", "Notifications"),
                FeatureHighlight("Embedded Photo Picker", "Seamless in-app gallery selector without bouncing users to system modal dialogues.", "Privacy"),
                FeatureHighlight("Advanced On-Device Agent APIs", "Direct OS hooks for local generative models executing complex multi-step mobile tasks.", "AI")
            ),
            majorHardware = listOf(
                HardwareMilestoneRef("Pixel 10 Series (Upcoming)", "Google", 2025, "Next-Gen Custom TSMC Silicon", "Pioneering fully Google-custom foundry silicon, advanced neural NPUs, and hardware ray tracing.")
            ),
            architectureLeap = "Major architectural cadence shift with bi-annual SDK release tracks (Q2 major API, Q4 minor feature drop).",
            easterEgg = EasterEggInfo("Baklava Sweet Teaser", "Developer Preview", "Geometric layered pastry artwork celebrating the return of delicious dessert naming.", EasterEggType.ANDROID_15_SPACE),
            accentColorHex = 0xFF00B0FF
        )
    )
}
