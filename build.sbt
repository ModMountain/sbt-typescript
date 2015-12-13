//
// Copyright 2014 Groupon.com
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
sbtPlugin := true

organization := "com.modmountain.sbt"

name := "sbt-typescript"

version := "0.3.0"

scalaVersion := "2.10.6"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.typesafeIvyRepo("releases"),
  Resolver.sonatypeRepo("releases")
)

libraryDependencies ++= Seq(
  "org.webjars" % "mkdirp" % "0.3.5",
  "org.webjars" % "typescript-node" % "1.5.3",
  "com.typesafe" % "jstranspiler" % "1.0.0"
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.1.3")

scalacOptions += "-feature"

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("https://github.com/ModMountain/sbt-typescript"))

pomExtra := (
  <scm>
    <url>git@github.com:ModMountain/sbt-typescript.git</url>
    <connection>scm:git:git@github.com:ModMountain/sbt-typescript.git</connection>
  </scm>
  <developers>
    <developer>
      <id>barp</id>
      <name>Brandon Arp</name>
      <url>http://www.arpnetworking.com</url>
    </developer>
    <developer>
      <id>sirsavary</id>
      <name>Jesse Savary</name>
      <url>http://www.jessesavary.com</url>
    </developer>
  </developers>
  )

scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }

scriptedBufferLog := false
