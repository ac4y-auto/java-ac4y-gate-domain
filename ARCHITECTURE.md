# java-ac4y-gate-domain - Architektúra Dokumentáció

## Áttekintés

Gate domain modul - felhasználó entitás az Ac4y hitelesítési rendszerhez.

**Verzió:** 1.0.0
**Java verzió:** 1.8
**Szervezet:** ac4y-auto

## Fő Komponensek

### 1. Ac4yUserAlgebra

**Csomag:** `ac4y.gate.algebra`

Alap algebra osztály felhasználói hitelesítő adatokkal.

**Mezők:**
- `user` (String): Felhasználónév
- `password` (String): Jelszó

### 2. Ac4yUser

**Csomag:** `ac4y.gate.domain`

Konkrét domain osztály. Az `Ac4yUserAlgebra`-t terjeszti ki (üres implementáció, örökli a mezőket).

## Függőségek

**Nincs külső ac4y függőség** - önálló modul.

Csak teszt függőség: JUnit 4.13.2

## AI Agent Használati Útmutató

### Token-hatékony Tudás

**Mit tartalmaz:**
- User entitás (user + password mezők)
- Algebra-domain minta

**Mit NEM tartalmaz:**
- Hitelesítési logika (lásd: ac4y-gate-service)
- REST kliens (lásd: ac4y-gate-service)
- Session kezelés

## Eredetileg

`IJAc4yGateModule/IJAc4yGateDomain` modulból kiemelve.

---
**Utolsó frissítés:** 2026-02-06
