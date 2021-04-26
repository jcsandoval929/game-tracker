import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Game } from './game';
import { GameService } from './game.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  year: number = new Date().getFullYear();
  public games: Game[] = [];
  public viewGame!: any;
  public editGame!: any;
  public deleteGame!: any;

  constructor(private gameService: GameService) {}

  ngOnInit() {
    this.getLibraryGames();
  }

  public getGames(): void {
    this.gameService.getGames().subscribe(
      (response: Game[]) => {
        this.games = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getLibraryGames(): void {
    this.gameService.getLibraryGames().subscribe(
      (response: Game[]) => {
        this.games = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getWishlistGames(): void {
    this.gameService.getWishlistGames().subscribe(
      (response: Game[]) => {
        this.games = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddGame(addForm: NgForm): void {
    document.getElementById('add-game-form')?.click();
    this.gameService.addGame(addForm.value).subscribe(
      (response: Game) => {
        console.log(response);
        if (response.wanted === true) {
          this.getWishlistGames();
        } else {
          this.getLibraryGames();
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateGame(game: Game): void {
    this.gameService.updateGame(game).subscribe(
      (response: Game) => {
        console.log(response);
        this.viewGame = response;
        if (response.wanted === true) {
          this.getWishlistGames();
        } else {
          this.getLibraryGames();
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteGame(gameId: number): void {
    this.gameService.deleteGame(gameId).subscribe(
      (response: void) => {
        console.log(response);
        if (this.deleteGame.wanted === true) {
          this.getWishlistGames();
        } else {
          this.getLibraryGames();
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(game: Game | null, mode: String): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');

    if (mode === 'view') {
      this.viewGame = game;
      button.setAttribute('data-bs-target', '#viewGameModal');
    }
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addGameModal');
    }
    if (mode === 'edit') {
      this.editGame = game;
      button.setAttribute('data-bs-target', '#updateGameModal');
    }
    if (mode === 'delete') {
      this.deleteGame = game;
      button.setAttribute('data-bs-target', '#deleteGameModal');
    }

    container?.appendChild(button);
    button.click();
  }
}
