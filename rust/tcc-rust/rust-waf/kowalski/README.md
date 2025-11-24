🧱 1. Proteção contra Injeções (SQL, NoSQL, Command Injection)

Mesmo com validação no backend (Spring Boot), é fácil algum endpoint passar parâmetros não tratados.
Um WAF pode inspecionar o corpo das requisições, cabeçalhos e query params e bloquear padrões suspeitos, por exemplo:

Strings como "' OR 1=1 --"

Comandos como sleep(), eval(), exec()

Operadores MongoDB ($ne, $gt, $where)

💡 Como implementar em Rust:

Use regex otimizadas com Aho-Corasick para detectar padrões perigosos.

Mantenha um conjunto de regras configuráveis em JSON ou YAML (facilita o teste e manutenção).

🛡️ 2. Filtro de Cross-Site Scripting (XSS)

O Angular protege bem com template escaping, mas:

Falhas ainda ocorrem via conteúdo dinâmico (ex: innerHTML, Markdown renderers, etc.).

Se você tiver APIs que retornam HTML, o risco é grande.

💡 No WAF:
Implemente uma análise de payloads que contenham:

Tags HTML (<script>, <img onerror>, etc.)

JavaScript inline

URLs suspeitas (javascript:)

💡 Em Rust:

Use uma lib como html5ever
 para parsear HTML e detectar tags perigosas com segurança.

🔑 3. Cross-Site Request Forgery (CSRF)

O Spring e Angular têm mecanismos de CSRF, mas um WAF pode reforçar:

Exigir verificação de tokens CSRF em métodos POST, PUT, DELETE.

Bloquear requisições sem Origin ou Referer válidos.

💡 Em Rust:

Analise cabeçalhos HTTP e cookies antes de rotear a requisição.

🚨 4. Rate Limiting e Deteção de Brute Force

Nem Angular nem Spring Boot controlam diretamente requisições massivas ou automatizadas.

💡 No WAF:

Monitore IPs e endpoints.

Defina limites: ex. 10 requisições / segundo.

Bloqueie tentativas repetidas de login falhas.

💡 Em Rust:

Use DashMap ou tokio::sync::RwLock para contadores em memória.

Integre com Redis se quiser persistência.

🔍 5. Normalização e Validação de URL / Path Traversal

Muitos ataques exploram URLs codificadas ou caminhos manipulados:

GET /api/../admin
GET /download?file=../../etc/passwd


💡 No WAF:

Normalize a URL (%2e%2e → ..)

Bloqueie sequências suspeitas.

Restringir acesso a rotas sensíveis.

💡 Rust:
url crate para parsing e normalização segura.

🧠 6. Regras de Anomalia e Perfil de Aplicação

O WAF pode aprender o comportamento normal da app e detectar requisições anômalas (Machine Learning leve ou heurísticas simples):

Parâmetros inesperados.

Headers incomuns.

Tamanho de payload fora do padrão.

💡 Em Rust:

Coletar métricas.

Implementar um modo learning e depois blocking.

🔒 7. Inspeção de Cabeçalhos e Hardening HTTP

Spring Boot e Angular não garantem todos os headers de segurança.

💡 O WAF pode reforçar:

Content-Security-Policy

X-Frame-Options

Strict-Transport-Security

Referrer-Policy

💡 Em Rust:

Middleware para adicionar/validar esses cabeçalhos antes do backend.

🧰 8. Logging, Auditoria e Modo de Aprendizado

Uma das partes mais legais de um WAF é poder:

Registrar requisições bloqueadas e suspeitas.

Operar em modo de aprendizado (apenas loga, não bloqueia).

Gerar relatórios (JSON, CSV).

💡 Em Rust:

Use tracing + serde_json para logs estruturados.

CLI ou dashboard web simples para visualizar eventos.

💡 Extras Avançados (para destaque no TCC)

Suporte a Regras ModSecurity (OWASP CRS) – compatibilidade com padrões de WAFs reais.

Inspeção de JSON / GraphQL – muito relevante em apps modernas.

Suporte a WebSockets – filtrar mensagens em tempo real.


