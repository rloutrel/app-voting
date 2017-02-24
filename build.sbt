name := "Voting Application"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.11.8"
  
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1"
).map(_ % Test)
    
// configuration of the main project
lazy val root = (project in file(".")).enablePlugins(PlayScala)