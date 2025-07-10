# 🤖 Chatbot Agentique avec Spring AI et MCP

## 🎯 Objectif du Projet

Ce projet vise à construire un chatbot intelligent de nouvelle génération, capable d’interagir de manière contextuelle avec les utilisateurs. Il repose sur l’intégration du **protocole MCP (Multi-Agent Communication Protocol)**, facilitant la communication entre divers agents ou services, quel que soit leur langage d’implémentation : Java (Spring), Python ou NodeJS.

### Objectifs clés :
- Conception de l’architecture MCP
- Création de serveurs MCP en Java, Python et NodeJS
- Intégration d’un client intelligent avec Spring AI (Llama3.1, Claude, OpenAI)
- Communication inter-agent via SSE ou STDIO
- Application modulaire et agentique

---

## 🧱 Structure du Projet

Le projet `mcp-demo-spring-python` est organisé en trois modules principaux :

### 🔹 `mcp-client` (Client Spring AI)

Client Java basé sur Spring Boot et Spring AI. Il gère l’interaction utilisateur, conserve le contexte de conversation et invoque dynamiquement les outils exposés via les serveurs MCP.

**Fonctionnalités :**
- Intégration LLMs (Llama3.1, Claude, OpenAI)
- Mémoire de conversation avec fenêtre glissante
- API REST via `AIRestController`
- Découverte automatique des outils MCP

---

### 🔹 `mcp-server` (Serveur MCP Java)

Serveur Java Spring Boot exposant des outils métiers via MCP. Il prend en charge la communication en temps réel avec SSE.

**Fonctionnalités :**
- Outils simulant une gestion d’entreprise (via `StockTools.java`)
- Communication SSE avec clients
- Intégration dynamique avec Spring AI

---

### 🔹 `python-mcp-server` (Serveur MCP Python)

Serveur Python simple exposant des outils via MCP et communiquant par STDIO avec le client.

**Fonctionnalités :**
- Implémentation de logique métier (`get_employee_info`)
- Communication via STDIO
- Intégration via fichier `mcp-servers.json`

---

## ⚙️ Technologies et Protocoles

- **Langages** : Java (Spring Boot), Python, NodeJS
- **IA** : Spring AI, Llama3.1, Claude, OpenAI
- **Communication** : MCP, SSE, STDIO
- **Outils de test** : Postman
- **Exécution locale LLM** : Ollama

---

## 🔍 Détails d’Implémentation

### 📁 `mcp-server` (Spring Boot)
- **`StockTools.java`** : expose des outils métiers fictifs (entreprises, actions…).
- **`McpServerApplication.java`** : configure et rend les outils accessibles via MCP.
- **`application.properties`** : définit les paramètres réseau, SSE et niveaux de log.

---

### 📁 `mcp-client` (Spring AI)
- **`AIAgent.java`** : agent conversationnel basé sur Spring AI.
- **`AIRestController.java`** : API REST pour interagir avec l’agent.
- **`McpClientApplication.java`** : appelle dynamiquement les outils MCP disponibles.
- **`application.properties`** : configuration du client et des LLMs.
- **`mcp-servers.json`** : gestion des serveurs NodeJS et Python déclenchés par ligne de commande.

---

### 📁 `python-mcp-server`
- **`server.py`** : expose un outil métier via FastMCP.
- **Mode STDIO** : communication directe avec le client Spring AI.

---

## 🧪 Test avec Postman

- Liste des outils MCP disponibles
- Appels directs aux fonctions comme `getAllCompanies`, `getCompanyByName`
- Tests des connexions SSE
- Réception de messages temps réel via `/mcp/message`

---

## ⚠️ Problèmes Techniques Rencontrés

- Blocage lors du lancement du serveur Python (`server.py`)
- `ollama run llama3.1` reste bloqué sans sortie
- Hypothèse : contraintes matérielles ou environnementales

---

## ✅ Conclusion

Ce projet démontre la mise en œuvre d’un système intelligent interopérable entre plusieurs langages et plateformes grâce au protocole MCP. Il constitue une base solide pour le développement d’agents distribués, intelligents et modulaires.


