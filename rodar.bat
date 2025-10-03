@echo off

rem https://superuser.com/questions/80485/exit-batch-file-from-subroutine
SETLOCAL
IF "%selfWrapped%"=="" (
  SET selfWrapped=true
  %ComSpec% /s /c ""%~0" %*"
  GOTO :EOF
)
rem Tudo o que está escrito abaixo é meu. O excerto acima é derivado do site indicado.

cd "%homepath%\Programacao\UnB_OO_EP1"
call :Compilar src\Leitura.java
call :Compilar src\Leitor.java

call :Compilar src\Pessoa.java
call :Compilar src\Paciente.java
call :Compilar src\Medico.java

call :Compilar src\Plano.java
call :Compilar src\PacienteEspecial.java

call :Compilar src\Consulta.java
call :Compilar src\Internacao.java
call :Compilar src\Diagnostico.java

call :Compilar src\Registro.java

call :Compilar src\UI.java
call :Compilar src\Main.java

:Compilar
	javac %~1
	if %ERRORLEVEL% EQU 0 (
		echo %~1 compilou
		exit /b 0
		)
	if %ERRORLEVEL% NEQ 0 (
		pause 
		exit
		)

java src\Main

pause