export type UserRegister = {
  username: string,
  email: string,
  password: string
}

export type UserLogin = {
  username: string,
  password: string
}

export type JwtResponse = {
  jwt: string;
  id: string;
  username: string;
  email: string;
  role: string;
}
