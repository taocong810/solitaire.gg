/* global define:false */
/* global Phaser:false */
/* global _:false */
define(['card/Rank', 'card/Suit'], function(Rank, Suit) {
  'use strict';

  var cardTextures = [];

  var blank, suitImages, blackRankImages, redRankImages, faceCardImages;

  function init(game, preferences) {
    if(cardTextures.length > 0) { throw new Error('Double initialize.'); }
    blank = new Phaser.Image(game, 0, 0, 'card-blank', 0);
    rerender(game, preferences);
  }

  function rerender(game, preferences) {
    suitImages = _.map([0, 1, 2, 3], function(i) {
      var ret = new Phaser.Image(game, 0, 0, 'card-suits', i);
      ret.anchor.setTo(0.5, 0.5);
      return ret;
    });
    redRankImages = _.map(Rank.all, function(r) {
      var ret = new Phaser.Image(game, 0, 0, 'card-ranks', r.value - 2);
      ret.anchor.setTo(0.5, 0.5);
      return ret;
    });
    blackRankImages = _.map(Rank.all, function(r) {
      var ret = new Phaser.Image(game, 0, 0, 'card-ranks', 13 + r.value - 2);
      ret.anchor.setTo(0.5, 0.5);
      return ret;
    });
    faceCardImages = _.flatten(_.map(Suit.all, function(s) {
      return _.map([0, 1, 2], function(i) {
        var ret = new Phaser.Image(game, 0, 0, 'card-faces', (s.index * 3) + i);
        ret.anchor.setTo(0.5, 0.5);
        return ret;
      });
    }));
    var layout = preferences['card-layout'];
    _.each(Suit.all, function(s) {
      _.each(Rank.all, function(r) {
        var tex = game.add.bitmapData(game.cardSet.cardWidth, game.cardSet.cardHeight);
        cardTextures[r.char + s.char] = renderCard(s, r, layout, tex);
      });
    });
  }

  var rankWidths = [0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 1.0, 0.9, 0.9, 0.9, 0.9];

  function renderCard(s, r, layout, tex) {
    tex.draw(blank, 0, 0);

    var suitImage = suitImages[s.index];
    var rankImage;
    if(s.color === 'red') {
      rankImage = redRankImages[r.value - 2];
    } else {
      rankImage = blackRankImages[r.value - 2];
    }

    switch(layout) {
      case 'a': // Standard
        if(r.locs === undefined) {
          if(r === Rank.ace) {
            tex.draw(suitImage, 200, 300, 200, 200);
          } else {
            tex.draw(faceCardImages[(s.index * 3) + r.value - 11], 200, 325, 350, 525);
          }
        } else {
          _.each(r.locs, function(loc) {
            tex.draw(suitImage, (loc[0] * 300) + 50, (loc[1] * 500) + 50, 100, 100);
          });
        }

        var rankWidth = rankWidths[r.value - 2];
        tex.draw(rankImage, 60 * rankWidth, 60, 80, 80);
        tex.draw(suitImage, (60 * rankWidth) + 60, 60, 50, 50);
        tex.draw(suitImage, 60 * rankWidth, 130, 50, 50);

        break;
      case 'b': // Classic
        if(r.locs === undefined) {
          if(r === Rank.ace) {
            tex.draw(suitImage, 200, 300, 200, 200);
          } else {
            tex.draw(faceCardImages[(s.index * 3) + r.value - 11], 200, 300, 400, 600);
          }
        } else {
          _.each(r.locs, function(loc) {
            if(loc[1] > 0.5) {
              suitImage.angle = 180;
            }
            tex.draw(suitImage, (loc[0] * 300) + 50, (loc[1] * 600), 100, 100);
            if(loc[1] > 0.5) {
              suitImage.angle = 0;
            }
          });
        }

        tex.draw(rankImage, 35, 45, 50, 50);
        tex.draw(suitImage, 35, 95, 50, 50);
        rankImage.angle = 180;
        suitImage.angle = 180;
        tex.draw(rankImage, 365, 565, 50, 50);
        tex.draw(suitImage, 365, 515, 50, 50);
        rankImage.angle = 0;
        suitImage.angle = 0;

        break;
      default:
        throw new Error('?: ' + layout);
    }

    return tex;
  }

  return {
    init: init,
    rerender: rerender,
    textures: cardTextures
  };
});
