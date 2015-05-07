import AssemblyKeys._

assemblySettings

name := "template-scala-parallel-similarproduct"

organization := "io.prediction"

parallelExecution in Test := false

test in assembly := {}

libraryDependencies ++= Seq(
  "io.prediction"    %% "core"          % pioVersion.value % "provided",
  "org.apache.spark" %% "spark-core"    % "1.3.0" % "provided",
  "org.apache.spark" %% "spark-mllib"   % "1.3.0" % "provided",
  "org.scalatest"    %% "scalatest"     % "2.2.1" % "test")
