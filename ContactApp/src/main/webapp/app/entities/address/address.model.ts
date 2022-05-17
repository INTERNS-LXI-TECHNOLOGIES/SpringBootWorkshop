import { IContact } from 'app/entities/contact/contact.model';

export interface IAddress {
  id?: number;
  placeName?: string | null;
  countryName?: string | null;
  contacts?: IContact[] | null;
}

export class Address implements IAddress {
  constructor(
    public id?: number,
    public placeName?: string | null,
    public countryName?: string | null,
    public contacts?: IContact[] | null
  ) {}
}

export function getAddressIdentifier(address: IAddress): number | undefined {
  return address.id;
}
