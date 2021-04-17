export interface Location {
  address: string;
  city: string;
  state: string;
  zip: string;
}

export function format(location: Location){
  return `${location.address}, ${location.city}, ${location.state} ${location.zip}`;
}
