$Env:DIR="$(Get-Location)"
$Env:CLASSPATH += ";$(Get-Location)\target\classes"
$Env:PORT = 3000