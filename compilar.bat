@echo off

chcp 65001
title Gerente de Compilação

rem https://superuser.com/questions/80485/exit-batch-file-from-subroutine
REM SETLOCAL
REM IF "%selfWrapped%"=="" (
  REM SET selfWrapped=true
  REM %ComSpec% /s /c ""%~0" %*"
  REM GOTO :EOF
REM )

setlocal EnableDelayedExpansion

if not exist %~dp0bin mkdir %~dp0bin
cd %~dp0src

call :Compilar UF
call :Compilar Especializacao

call :Compilar Seq
call :Compilar Cpf
call :Compilar Crm
call :Compilar Status

call :Compilar Horario
call :Compilar Periodo

call :Compilar Pessoa
call :Compilar Paciente

call :Compilar Medico

call :Compilar Plano
call :Compilar PacienteEspecial

call :Compilar Consulta
call :Compilar Internacao
call :Compilar Diagnostico
call :Compilar Quarto

call :Compilar Registro

call :Compilar UI

call :Compilar Leitura
call :Compilar Leitor

call :Compilar Main

GOTO Rodar

:Compilar
	javac %~1.java -d %~dp0bin -Xdiags:verbose
	if %ERRORLEVEL% EQU 0 (
		echo %~1 compilou
		exit /b 0
		)
	if %ERRORLEVEL% NEQ 0 (
		pause 
		exit
		)

:Rodar
	cd ..
	START /MAX rodar.bat
	exit