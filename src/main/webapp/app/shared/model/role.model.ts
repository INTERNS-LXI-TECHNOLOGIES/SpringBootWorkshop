export interface IRole {
  id?: number;
  rolename?: string;
}

export class Role implements IRole {
  constructor(public id?: number, public rolename?: string) {}
}
