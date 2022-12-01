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
  jwt: string,
  id: string,
  username: string,
  email: string,
  role: string,
}

export type Artist = {
  id: string,
  artistName: string,
  photo: string,
}

export type Song = {
  id: string,
  name: string,
}

export type Playlist = {
  id: string,
  name: string,
}
