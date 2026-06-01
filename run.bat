@echo off
REM Compile and run StudentGradeTracker
javac StudentGradeTracker.java
if errorlevel 1 (
  echo Compilation failed.
  pause
  exit /b %errorlevel%
)
java StudentGradeTracker
pause
