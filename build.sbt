import com.bowlingx.sbt.plugins.Wro4jPlugin._
import Wro4jKeys._


organization := "net.spottedzebra"

name := "My Scalatra Web App"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

classpathTypes ~= (_ + "orbit")

resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra" % "2.2.0-RC2",
  "org.scalatra" % "scalatra-scalate" % "2.2.0-RC2",
  "org.scalatra" % "scalatra-specs2" % "2.2.0-RC2" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container;test",
  "com.mongodb.casbah" %% "casbah" % "2.1.5-1",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
)

// import task settings
seq(wro4jSettings: _*)

// If you use xsbt-web-plugin, this will add compiled files to your war file:
(webappResources in Compile) <+= (targetFolder in generateResources in Compile)
