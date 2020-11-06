$Env:DIR="$(Get-Location)"
$Env:CLASSPATH += ";$(Get-Location)\target\classes;$(Get-Location)\target\dependency\jackson-core-2.11.3.jar"
$Env:PORT = 3000