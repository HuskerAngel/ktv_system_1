plugins {
    id("com.android.application")
}




android {
    aaptOptions.cruncherEnabled = false
    aaptOptions.useNewCruncher = false
    namespace = "com.example.ktv_system"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ktv_system"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {


    implementation("com.github.ctiao:dfm:0.4.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.exoplayer:exoplayer-core:2.15.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.15.1")
    implementation("com.github.ctiao:dfm:0.4.2")


    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.test:core:1.4.0")
    androidTestImplementation ("androidx.test:rules:1.5.0@aar")
    androidTestImplementation ("androidx.test:runner:1.4.0")
    testImplementation ("org.mockito:mockito-core:3.11.2")


}

