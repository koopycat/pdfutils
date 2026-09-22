plugins {
    val kotlinVersion = "2.4.20"

    id("application")

    kotlin("jvm") version kotlinVersion
}

group = "de.vkoop"
version = "v1.0.16"

repositories {
    mavenCentral()
}

distributions {
    main {
        version = ""
    }
}

val picoliVersion = project.property("picoliVersion") as String
val openpdfVersion = project.property("openpdfVersion") as String

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.github.librepdf:openpdf:$openpdfVersion")
    implementation("info.picocli:picocli:$picoliVersion")

    // JUnit 5 dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.1")

    // Mockito for mocking in tests
    testImplementation("org.mockito:mockito-core:5.8.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:6.3.0")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set( "de.vkoop.pdfutils.AppKt")
}

tasks.test {
    // Use the built-in JUnit support of Gradle.
    useJUnitPlatform()
}