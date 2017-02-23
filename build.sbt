name := "Voting Application"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.11.8"
  
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test
    
// configuration of the main project
lazy val root = (project in file(".")).enablePlugins(PlayScala)