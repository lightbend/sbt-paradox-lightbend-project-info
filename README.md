# Paradox Project Info for Lightbend

This plugin extends the [sbt-paradox-project-info](https://github.com/lightbend/sbt-paradox-project-info) with the
default global `readinessLevels` settings that are used for Lightbend/Akka projects.

It is intended to be used for the Lightbend/Akka umbrella of projects, and not as a public project to use on "any"
project.

## Usage

Use the sbt plugin for Akka Paradox:

```scala
addSbtPlugin("com.lightbend.lightbend" % "sbt-paradox-lightbend-project-info" % "<version>")
```

Since this is an auto-plugin that automatically triggers its already enabled when you include it as a dependency.

## Releasing

- Tag the commit you want to release and push it
- Github actions should automatically release
  to [maven-central](https://maven-badges.herokuapp.com/maven-central/com.lightbend.paradox/sbt-paradox-lightbend-project-info)
