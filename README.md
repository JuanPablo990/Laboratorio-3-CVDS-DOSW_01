

# Laboratorio 03 - TDD – Pruebas de Software – Agilismo y Scrum – Análisis de Requerimientos

**Integrantes :**
- Sebastian Albarracin Silva
- Raquel Iveth Selma Ayala
- Juan Pablo Nieto Cortes

**Nombre de la rama :**
`feature/lab3_Nieto_Albarracin_Selma_2025-2'

# Reto 1: Identificando los Requerimientos

## Reglas de Negocio
- Los números de cuenta deben tener exactamente **10 dígitos**.
- Solo son válidos si los **dos primeros dígitos corresponden a un banco registrado** (ejemplo: `01 → BANCOLOMBIA`, `02 → DAVIVIENDA`).
- Las cuentas **no pueden contener letras ni caracteres especiales**, únicamente números.
- Cada cuenta debe estar asociada a un cliente único.
- No se pueden realizar depósitos en cuentas inexistentes o inválidas.
- El sistema debe garantizar la integridad y seguridad de la información financiera.

## Funcionalidades Principales
1. **Crear cuenta bancaria**
    - Validar el número de cuenta según las reglas de negocio.
    - Asociar la cuenta a un cliente.
    - Iniciar con un saldo en cero.

2. **Validar cuentas**
    - Verificar que el número de cuenta cumpla los criterios de formato y banco válido.
    - Confirmar que la cuenta exista en el sistema.

3. **Consultar saldo**
    - Permitir al cliente visualizar el saldo actual de su cuenta.

4. **Realizar depósitos**
    - Registrar depósitos en cuentas válidas.
    - Actualizar el saldo de la cuenta de manera inmediata.
    - Generar trazabilidad del movimiento.

## Actores Principales
- **Cliente**: Persona que posee una cuenta bancaria y realiza operaciones (consultar saldo, depositar).
- **Sistema Bankify**: Aplicación que valida, administra y procesa las operaciones financieras.
- **Administrador/Operador del Banco** (opcional en versiones iniciales): Encargado de registrar bancos válidos o realizar tareas de mantenimiento.

## Precondiciones
- El sistema debe tener configurados los **códigos de bancos válidos**.
- El cliente debe estar **registrado en el sistema** antes de crear una cuenta.
- La infraestructura necesaria debe estar disponible:
 


