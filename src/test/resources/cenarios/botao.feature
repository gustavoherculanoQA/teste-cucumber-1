#language: pt

Funcionalidade: Login e senha

  Cenario: Email e senha corretos
    Dado que eu estou na pagina de login
    Quando eu preecher login "dudu@local.dev" e senha "1234"
    E eu clico no botao Entrar
    Entao o sistema mostra a notificacao "Login com sucesso!"

  Cenario: Email correto e senha errada
    Dado que eu estou na pagina de login
    Quando eu preecher login "dudu@local.dev" e senha "xxx"
    E eu clico no botao Entrar
    Entao o sistema mostra a notificacao "Incorrect password"

  Cenario: Email vazio e senha vazia
    Dado que eu estou na pagina de login
    Quando eu clico no botao Entrar
    Entao o sistema mostra a notificacao "Fill in email"

  Cenario: Email incorreto e senha correta
    Dado que eu estou na pagina de login
    Quando eu preecher login "dudu@local.dev.com" e senha "12345"
    E eu clico no botao Entrar
    Entao o sistema mostra a notificacao "User not found"

  Cenario: Email incorreto e senha incorreta
    Dado que eu estou na pagina de login
    Quando eu preecher login "dudu@local.dev.com" e senha "12345"
    E eu clico no botao Entrar
    Entao o sistema mostra a notificacao "User not found"

  Cenario: Email invalido
    Dado que estou na pagina de login
    Quando eu preecher login "dudu" e senha "12345"
    E eu clico no botao Entrar
    Entao o sistema mostra a notificacao "Invalid email"