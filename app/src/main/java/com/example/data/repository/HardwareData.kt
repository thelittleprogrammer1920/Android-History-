package com.example.data.repository

import com.example.data.model.HardwareMilestone

object HardwareData {
    val devices = listOf(
        HardwareMilestone(
            id = "htc_dream",
            name = "HTC Dream / T-Mobile G1",
            manufacturer = "HTC / T-Mobile",
            releaseYear = 2008,
            androidVersion = "Android 1.0 Base",
            headline = "The Genesis of Android Commercial Hardware",
            significance = "The device that proved an open-source mobile OS could challenge Symbian, BlackBerry, and iOS. Its innovative slide-out landscape mechanism, clickable trackball, and angled bottom 'chin' kept your thumb anchored during one-handed navigation.",
            keySpecs = listOf(
                "Processor: Qualcomm MSM7201A @ 528 MHz",
                "RAM: 192 MB | ROM: 256 MB (microSD expansion)",
                "Display: 3.2-inch TFT capacitive (320 x 480 HVGA)",
                "Camera: 3.15 MP autofocus (no flash)",
                "Battery: 1,150 mAh removable"
            ),
            standoutInnovations = listOf(
                "First commercial Android phone in human history",
                "Signature slide-out 5-row tactile hardware QWERTY keyboard",
                "Miniature physical optical trackball for precise text selection",
                "Ergonomic angled chin housing physical call/end/menu/home buttons"
            ),
            heroQuote = "“The first handset to unleash the freedom of the Android platform upon the world.”",
            accentColorHex = 0xFF78909C
        ),
        HardwareMilestone(
            id = "motorola_droid",
            name = "Motorola DROID",
            manufacturer = "Motorola / Verizon",
            releaseYear = 2009,
            androidVersion = "Android 2.0 Eclair",
            headline = "The iPhone Killer that Saved Motorola",
            significance = "Accompanied by Verizon's legendary $100M 'Droid Does' advertising campaign, the DROID was the first mainstream Android mega-hit. It made Android a household name in North America and established Android as the rebel platform for power users.",
            keySpecs = listOf(
                "Processor: TI OMAP 3430 @ 550 MHz (ARM Cortex-A8)",
                "RAM: 256 MB | Display: 3.7-inch (854 x 480 FWVGA)",
                "Camera: 5 MP dual-LED flash with mechanical shutter key",
                "Weight: 169g solid metal industrial construction",
                "Navigation: Directional gold D-pad next to keyboard"
            ),
            standoutInnovations = listOf(
                "Launched free Google Maps Navigation with spoken voice turns",
                "Razor-thin slide-out keyboard with gold 4-way D-pad",
                "Gorgeous high-density 16:9 widescreen display",
                "Iconic robotic 'DROID!' boot sound and metallic industrial styling"
            ),
            heroQuote = "“iDon't have a real keyboard. Droid Does. iDon't run simultaneous apps. Droid Does.”",
            accentColorHex = 0xFFFF5252
        ),
        HardwareMilestone(
            id = "nexus_one",
            name = "Nexus One",
            manufacturer = "Google / HTC",
            releaseYear = 2010,
            androidVersion = "Android 2.1 Eclair",
            headline = "Google's Direct-to-Consumer Masterpiece",
            significance = "Google's first 'Pure Google' flagship, sold unlocked directly on Google's website. It showed the entire industry how fast Android could be when unburdened by carrier bloatware and heavy OEM skins.",
            keySpecs = listOf(
                "Processor: 1.0 GHz Qualcomm Snapdragon QSD8250 (Scorpion)",
                "RAM: 512 MB | Storage: 512 MB internal + 4GB microSD",
                "Display: 3.7-inch AMOLED (480 x 800 WVGA)",
                "Design: Teflon-coated aluminum unibody with dual microphones"
            ),
            standoutInnovations = listOf(
                "Illuminated multi-color trackball flashing custom notification colors",
                "Active secondary noise-cancelling microphone on back",
                "Blazing 1GHz mobile CPU pushing real-time animated Live Wallpapers",
                "Laser-engraved custom text from Google on the aluminum backplate"
            ),
            heroQuote = "“The superphone that initiated Google's direct hardware vision.”",
            accentColorHex = 0xFF4285F4
        ),
        HardwareMilestone(
            id = "nexus_s",
            name = "Nexus S",
            manufacturer = "Google / Samsung",
            releaseYear = 2010,
            androidVersion = "Android 2.3 Gingerbread",
            headline = "First NFC Phone & Curved Contour Glass",
            significance = "Marked Google's partnership with Samsung, leveraging Samsung's industry-leading Super AMOLED display technology. Introduced Near Field Communication (NFC) hardware to the Android ecosystem years before Apple Pay existed.",
            keySpecs = listOf(
                "Processor: 1.0 GHz Samsung Hummingbird (Cortex-A8)",
                "Display: 4.0-inch Super AMOLED Contour curved glass",
                "Storage: 16 GB iNAND flash (first Nexus without microSD)",
                "Sensors: NFC chip, 3-axis gyroscope, barometer"
            ),
            standoutInnovations = listOf(
                "First Android smartphone with integrated hardware NFC reader/writer",
                "Ergonomically curved 'Contour Display' glass conforming to your face",
                "First Nexus to drop physical trackball for pure capacitive touch",
                "Signature retro CRT TV screen-off animation"
            ),
            heroQuote = "“Lead the way for tap-to-pay and high-contrast OLED screens.”",
            accentColorHex = 0xFF8D6E63
        ),
        HardwareMilestone(
            id = "galaxy_nexus",
            name = "Galaxy Nexus",
            manufacturer = "Google / Samsung",
            releaseYear = 2011,
            androidVersion = "Android 4.0 Ice Cream Sandwich",
            headline = "The First Buttonless HD Super AMOLED Giant",
            significance = "Pioneered the modern front face of smartphones: no hardware home or back buttons, just edge-to-edge glass and software on-screen keys. Unveiled alongside Ice Cream Sandwich in Hong Kong.",
            keySpecs = listOf(
                "Processor: TI OMAP 4460 dual-core @ 1.2 GHz",
                "RAM: 1 GB | Storage: 16/32 GB",
                "Display: 4.65-inch 720p HD Super AMOLED (1280 x 720, 316 ppi)",
                "Camera: Zero shutter-lag 5 MP sensor with 1080p video"
            ),
            standoutInnovations = listOf(
                "Complete elimination of physical front navigation keys for on-screen soft buttons",
                "Zero shutter-lag camera capturing photos the exact instant you tapped",
                "Face Unlock biometric authentication",
                "Centered RGB LED notification light in the chin"
            ),
            heroQuote = "“The blueprint for the modern all-screen smartphone era.”",
            accentColorHex = 0xFF00E5FF
        ),
        HardwareMilestone(
            id = "nexus_4",
            name = "Nexus 4",
            manufacturer = "Google / LG",
            releaseYear = 2012,
            androidVersion = "Android 4.2 Jelly Bean",
            headline = "Holographic Glass & The $299 Unlocked Disruption",
            significance = "Google shocked the smartphone industry by selling an unlocked, flagship-tier phone for only $299 with no contract. It sold out within minutes worldwide, causing Google Play store crashes.",
            keySpecs = listOf(
                "Processor: Qualcomm Snapdragon S4 Pro quad-core @ 1.5 GHz",
                "RAM: 2 GB | Storage: 8 / 16 GB",
                "Display: 4.7-inch True HD IPS Plus (1280 x 768)",
                "Features: Qi wireless charging standard, crystal reflection back"
            ),
            standoutInnovations = listOf(
                "Holographic 'crystal reflection' rear glass catching light in 3D sparkles",
                "Standard Qi wireless inductive charging built-in",
                "Unprecedented price-to-performance ratio ($299 unlocked)",
                "Soft-touch rubberized side bumpers for drop resilience"
            ),
            heroQuote = "“Proved high-end flagship smartphones didn't have to cost $650.”",
            accentColorHex = 0xFF9C27B0
        ),
        HardwareMilestone(
            id = "nexus_5",
            name = "Nexus 5",
            manufacturer = "Google / LG",
            releaseYear = 2013,
            androidVersion = "Android 4.4 KitKat",
            headline = "The Most Beloved Nexus Phone Ever Built",
            significance = "Universally regarded as the pinnacle of the Nexus program. Incredibly lightweight, stealthy minimalist matte finish, vibrant 1080p display, and blazing Snapdragon 800 processor for just $349.",
            keySpecs = listOf(
                "Processor: Qualcomm Snapdragon 800 quad-core @ 2.26 GHz",
                "RAM: 2 GB | Storage: 16 / 32 GB",
                "Display: 4.95-inch Full HD IPS (1920 x 1080, 445 ppi)",
                "Camera: 8 MP with Optical Image Stabilization (OIS)"
            ),
            standoutInnovations = listOf(
                "Tactile ceramic volume and power buttons",
                "Optical Image Stabilization (OIS) at an accessible price point",
                "Featherweight 130g design with soft-touch tactile grip",
                "The community champion for custom ROMs and long-term hacking"
            ),
            heroQuote = "“The people's champion: blistering performance, pure Android, and zero pretension.”",
            accentColorHex = 0xFFD32F2F
        ),
        HardwareMilestone(
            id = "nexus_7",
            name = "Nexus 7 (2012 & 2013)",
            manufacturer = "Google / ASUS",
            releaseYear = 2012,
            androidVersion = "Android 4.1 / 4.3 Jelly Bean",
            headline = "The $199 Tablet That Changed Everything",
            significance = "Proved that Android tablets could succeed by hitting an unbeatable $199 price point. Built with ASUS, it became the gold standard for portable 7-inch media consumption and e-reading.",
            keySpecs = listOf(
                "Processor: Nvidia Tegra 3 quad-core (2012) / Snapdragon S4 Pro (2013)",
                "Display: 7.0-inch 1200x800 (2012) / 1920x1200 Full HD (2013, 323 ppi)",
                "Design: Dimpled leatherette back inspired by driving gloves (2012)",
                "Stereo speakers with Fraunhofer surround sound"
            ),
            standoutInnovations = listOf(
                "Democratized high-resolution tablet computing under $200",
                "Google Now predictive showcase device",
                "Lightweight one-handed reading form factor",
                "2013 model added Qi wireless charging and world's sharpest 7-inch panel"
            ),
            heroQuote = "“The device that saved the Android tablet category from extinction.”",
            accentColorHex = 0xFFFF9800
        ),
        HardwareMilestone(
            id = "nexus_6p",
            name = "Nexus 6P",
            manufacturer = "Google / Huawei",
            releaseYear = 2015,
            androidVersion = "Android 6.0 Marshmallow",
            headline = "The Swan Song of the Nexus Program",
            significance = "The final and most premium Nexus phone. With an aeronautical-grade aluminum unibody, distinctive black glass camera visor, and massive 1.55μm camera pixels, it was the stepping stone into the Pixel era.",
            keySpecs = listOf(
                "Processor: Qualcomm Snapdragon 810 v2.1 octa-core",
                "RAM: 3 GB | Display: 5.7-inch Quad HD AMOLED (2560 x 1440)",
                "Camera: 12.3 MP Sony IMX377 with large 1.55 μm pixels and laser AF",
                "Audio: Dual front-facing stereo speakers | Ports: USB Type-C"
            ),
            standoutInnovations = listOf(
                "Iconic raised horizontal glass camera visor along the top back",
                "Blazing fast rear-mounted Nexus Imprint fingerprint sensor",
                "Superb low-light photography without OIS due to giant sensor pixels",
                "Transition to universal reversible USB Type-C fast charging"
            ),
            heroQuote = "“The most luxurious Nexus ever made, setting the stage for the Pixel.”",
            accentColorHex = 0xFF546E7A
        ),
        HardwareMilestone(
            id = "pixel_1",
            name = "Google Pixel & Pixel XL",
            manufacturer = "Google / HTC (Contract)",
            releaseYear = 2016,
            androidVersion = "Android 7.1 Nougat",
            headline = "The 'Made by Google' Revolution Begins",
            significance = "Google pivoted from reference devices for developers to competing directly against the iPhone with custom hardware and bespoke software. Unveiled the conversational Google Assistant and captured the crown for best smartphone camera on earth.",
            keySpecs = listOf(
                "Processor: Qualcomm Snapdragon 821 @ 2.15 GHz",
                "RAM: 4 GB LPDDR4 | Storage: 32 / 128 GB UFS 2.0",
                "Camera: 12.3 MP HDR+ with zero shutter lag (DxOMark record 89)",
                "Colors: Quite Black, Very Silver, and Limited Really Blue"
            ),
            standoutInnovations = listOf(
                "Exclusive launch of conversational Google Assistant",
                "Proprietary HDR+ multi-frame computational exposure stacking",
                "Signature half-glass, half-metal two-tone rear window",
                "Free unlimited lifetime original-quality Google Photos cloud backup"
            ),
            heroQuote = "“The highest-rated smartphone camera ever tested, by anyone.”",
            accentColorHex = 0xFF1976D2
        ),
        HardwareMilestone(
            id = "pixel_3",
            name = "Google Pixel 3 & 3 XL",
            manufacturer = "Google",
            releaseYear = 2018,
            androidVersion = "Android 9 Pie",
            headline = "Night Sight & Single-Lens Sorcery",
            significance = "While competitors added two, three, or four camera lenses, Google proved software and machine learning mattered more. Pixel 3 shocked the tech world with Night Sight, taking bright daylight-like photos in total darkness with one camera.",
            keySpecs = listOf(
                "Processor: Qualcomm Snapdragon 845 | Security: Titan M chip",
                "Display: 5.5-inch (Pixel 3) / 6.3-inch QHD+ notched (Pixel 3 XL)",
                "Camera: 12.2 MP dual-pixel OIS + dual front cameras (ultrawide group selfie)",
                "Coprocessor: Pixel Visual Core dedicated image NPU"
            ),
            standoutInnovations = listOf(
                "Night Sight computational photography turning night into day",
                "Titan M custom hardware security chip protecting disk encryption and OS keys",
                "Call Screen feature using Google Assistant to screen telemarketers in realtime",
                "Matte-etched soft-touch glass back supporting wireless charging"
            ),
            heroQuote = "“One lens, endless machine learning magic: the apex of computational photography.”",
            accentColorHex = 0xFFE91E63
        ),
        HardwareMilestone(
            id = "pixel_6",
            name = "Google Pixel 6 & 6 Pro",
            manufacturer = "Google",
            releaseYear = 2021,
            androidVersion = "Android 12 (Material You)",
            headline = "Google's First Custom Silicon: Tensor",
            significance = "The dramatic reinvention of the Pixel line. Google abandoned off-the-shelf Qualcomm chips to forge Google Tensor, focusing on custom Machine Learning TPUs. Introduced the iconic camera visor across the rear and paired seamlessly with Material You.",
            keySpecs = listOf(
                "Processor: Custom Google Tensor SoC (2x Cortex-X1, 2x A76, 4x A55)",
                "Security: Titan M2 security coprocessor",
                "Cameras: 50 MP Samsung GN1 main + 12 MP ultrawide + 48 MP 4x periscope (Pro)",
                "Display: 6.7-inch 120Hz LTPO QHD+ curved AMOLED (Pro)"
            ),
            standoutInnovations = listOf(
                "First custom Google Tensor silicon for on-device machine learning",
                "Magic Eraser tool removing photobombers with one tap",
                "Iconic edge-to-edge horizontal camera bar visor design",
                "Real Tone camera tuning honoring authentic human skin tones"
            ),
            heroQuote = "“The biggest hardware leap in Google's history, powered by custom Google silicon.”",
            accentColorHex = 0xFF673AB7
        ),
        HardwareMilestone(
            id = "pixel_fold",
            name = "Google Pixel Fold",
            manufacturer = "Google",
            releaseYear = 2023,
            androidVersion = "Android 13 / 14",
            headline = "Google's First Foldable Smartphone",
            significance = "Google's flagship entry into the foldable arena. Opted for a wide, comfortable passport-like outer screen and custom 180-degree fluid friction hinge, turning into a 7.6-inch tablet designed around Android's large-screen multitasking.",
            keySpecs = listOf(
                "Processor: Google Tensor G2 with Titan M2",
                "Outer Display: 5.8-inch 17.4:9 OLED (readable like a standard phone)",
                "Inner Display: 7.6-inch 120Hz flexible OLED (1840 x 2208)",
                "Hinge: 180-degree fluid friction multi-alloy steel hinge"
            ),
            standoutInnovations = listOf(
                "Passport aspect ratio eliminating the narrow awkwardness of tall foldables",
                "Tabletop / tent mode for hands-free video and long-exposure astrophotography",
                "Dual-screen live translation displaying subtitles to both conversationalists",
                "Rear camera selfie mode using the outer screen as a viewfinder"
            ),
            heroQuote = "“A phone when you want it, a tablet when you need it: Android's foldable vision realized.”",
            accentColorHex = 0xFF009688
        ),
        HardwareMilestone(
            id = "pixel_9_pro",
            name = "Google Pixel 9 Pro & Fold",
            manufacturer = "Google",
            releaseYear = 2024,
            androidVersion = "Android 15",
            headline = "The Multimodal Gemini AI Flagship",
            significance = "Represents Google's modern hardware zenith. Powered by Tensor G4 with 16GB RAM dedicated to on-device Gemini Nano multimodal intelligence, aerospace-grade satin glass, and direct satellite SOS communication.",
            keySpecs = listOf(
                "Processor: Google Tensor G4 with enhanced TPU for multimodal AI",
                "RAM: 16 GB LPDDR5X (with dedicated Gemini memory partition)",
                "Display: Super Actua display reaching 3,000 nits peak brightness",
                "Connectivity: Satellite SOS emergency connectivity"
            ),
            standoutInnovations = listOf(
                "Gemini Nano on-device multimodal AI analyzing text, audio, and images locally",
                "Add Me camera feature allowing the photographer to be inserted into group photos",
                "Pixel Screenshots app indexing and recalling all visual memories with local AI",
                "Flawless flat-edge industrial design with sculpted floating camera pill"
            ),
            heroQuote = "“The complete synergy of custom silicon, Gemini intelligence, and pure Android 15.”",
            accentColorHex = 0xFF2E7D32
        )
    )
}
