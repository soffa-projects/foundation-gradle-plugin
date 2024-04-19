package io.soffa.tools.gradle.spring

import org.gradle.api.Plugin
import org.gradle.api.Project

class SpringBootDependencyPlugin implements Plugin<Project> {

    void apply(Project project) {
        // project.plugins.apply("io.spring.dependency-management")
        project.dependencies {
            implementation platform('org.springframework.boot:spring-boot-dependencies:3.2.4')
            implementation platform('org.springframework.cloud:spring-cloud-dependencies:2023.0.1') // 2021.0.0-RC1
            testImplementation("org.springframework.boot:spring-boot-starter-test") {
                exclude(group: "com.vaadin.external.google")
            }
        }

        project.test {
            useJUnitPlatform()
        }

        if (project.plugins.hasPlugin("kotlin")) {
            project.plugins.apply("kotlin-spring")
        }

    }


}
