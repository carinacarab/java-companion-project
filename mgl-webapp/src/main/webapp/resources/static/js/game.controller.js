'use strict';

angular.module('MGLApp').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.updateGame = function() {
				return GameService.updateGame(self.game).then( function() {
					self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
