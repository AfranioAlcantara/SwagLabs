#language:pt

  @cadastro
  Funcionalidade: como usuario quero entrar no site swaglabs com usuario e senha

  Contexto: Logar no site com e-mail e senha
    Dado que o usuario acesse a tela de login do site via URL "https://www.saucedemo.com/"
    Esquema do Cenario: realizar cadastro de usuario com dados validos
      Quando informar um Email <email> valido
      E informar a Senha <senha>
      E clicar no botao Login <login>
      Entao devera Logar <logar> o usuario

      Exemplos:
      |       email        |     senha    |        logar      |
      |"standard_user"     |"secret_sauce"|"login com sucesso"|
      |"qatester@gmail.com"|"@qatester123"|"login sem sucesso"|
