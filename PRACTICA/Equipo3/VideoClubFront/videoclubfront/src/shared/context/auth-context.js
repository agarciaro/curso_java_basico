import { createContext } from "react";

export const AuthContext = createContext({
  isLoggedIn: false,
  username: null,
  token: null,
  roles: null,
  login: () => {},
  logout: () => {},
});
