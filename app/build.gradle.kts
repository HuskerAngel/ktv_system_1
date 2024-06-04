plugins {
    id("com.android.application")
}




android {
    dexOptions{javaMaxHeapSize = "2048m"}
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
        multiDexEnabled = true
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

    testOptions {
        unitTests {

        }
    }




}

dependencies {


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.exoplayer:exoplayer-core:2.15.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.15.1")
    implementation("com.github.ctiao:dfm:0.4.2")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation ("org.robolectric:robolectric:4.7")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.test:core:1.5.0")
    androidTestImplementation ("androidx.test:rules:1.5.0@aar")
    androidTestImplementation ("androidx.test:runner:1.5.2")
    testImplementation ("org.mockito:mockito-core:5.12.0")
    testImplementation ("androidx.fragment:fragment-testing:1.5.6")


}

