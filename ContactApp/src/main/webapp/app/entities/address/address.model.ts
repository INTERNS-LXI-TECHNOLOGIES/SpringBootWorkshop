import { IContact } from 'app/entities/contact/contact.model';

export interface IAddress {
  id?: number;
  placeName?: string | null;
  country?: string | null;
  contact?: IContact | null;
  contact?: IContact | null;
}

export class Address implements IAddress {
  constructor(
    public id?: number,
    public placeName?: string | null,
    public country?: string | null,
    public contact?: IContact | null,
    public contact?: IContact | null
  ) {}
}

export function getAddressIdentifier(address: IAddress): number | undefined {
  return address.id;
}
