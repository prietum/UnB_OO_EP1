@echo off

rem https://superuser.com/questions/80485/exit-batch-file-from-subroutine
SETLOCAL
IF "%selfWrapped%"=="" (
  SET selfWrapped=true
  %ComSpec% /s /c ""%~0" %*"
  GOTO :EOF
)
rem Tudo o que está escrito abaixo é meu. O excerto acima é derivado do site indicado.

cd "%homepath%\Programacao\UnB_OO_EP1"\src
call :Compilar Leitura.java
call :Compilar Leitor.java

call :Compilar UF.java
call :Compilar Especializacao.java

call :Compilar Crm.java
call :Compilar Horario.java
call :Compilar Periodo.java

call :Compilar Pessoa.java
call :Compilar Paciente.java

call :Compilar Medico.java

call :Compilar Plano.java
call :Compilar PacienteEspecial.java

call :Compilar Consulta.java
call :Compilar Internacao.java
call :Compilar Diagnostico.java
call :Compilar Quarto.java

call :Compilar Registro.java

call :Compilar UI.java
call :Compilar Main.java

GOTO Rodar

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

:Rodar
	java Main
	
	echo Programa concluído.
	pause