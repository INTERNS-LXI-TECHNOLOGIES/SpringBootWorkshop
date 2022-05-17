import { IAddress } from 'app/entities/address/address.model';

export interface IContact {
  id?: number;
  contactName?: string | null;
  contactNumber?: string | null;
  email?: string | null;
  address?: IAddress | null;
}

export class Contact implements IContact {
  constructor(
    public id?: number,
    public contactName?: string | null,
    public contactNumber?: string | null,
    public email?: string | null,
    public address?: IAddress | null
  ) {}
}

export function getContactIdentifier(contact: IContact): number | undefined {
  return contact.id;
}
