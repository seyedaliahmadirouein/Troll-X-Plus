@echo off
echo Building TrollXPlus Plugin...
echo.

REM Check if Maven is installed
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Error: Maven is not installed or not in PATH
    echo Please install Maven and try again
    pause
    exit /b 1
)

REM Clean and compile
echo Cleaning previous builds...
mvn clean

echo.
echo Compiling plugin...
mvn package

if %errorlevel% equ 0 (
    echo.
    echo ================================
    echo Build successful!
    echo Plugin JAR location: target\TrollXPlus-1.0.0.jar
    echo ================================
    echo.
    echo Copy this JAR file to your server's plugins folder
) else (
    echo.
    echo ================================
    echo Build failed!
    echo Check the error messages above
    echo ================================
)

echo.
pause