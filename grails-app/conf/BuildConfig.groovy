grails.servlet.version = "3.0"
grails.project.work.dir = "target"
grails.project.target.level = 1.7
grails.project.source.level = 1.7

grails.project.dependency.resolver = "maven"

grails.project.dependency.resolution = {
    //legacyResolve true // if using Grails > 2.2
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    repositories {
        mavenLocal()
        mavenRepo ("http://nexus.ala.org.au/content/groups/public/") {
            updatePolicy 'always'
        }
    }
    dependencies {
        compile ('au.org.ala:ala-cas-client:2.3')
    }

    plugins {
        build(":release:3.1.1",
                ":rest-client-builder:2.1.1") {
            export = false
        }
        compile (':asset-pipeline:2.14.1')  { export = false }
        compile (':resources:1.2.14') { export = false }
        runtime ":jquery:1.11.1"
    }
}