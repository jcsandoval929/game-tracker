export interface Game {
  id: number;
  title: string;
  description: string;
  genre: string;
  developer: string;
  completed: boolean;
  wanted: boolean;
  imageUrl: string;
}
