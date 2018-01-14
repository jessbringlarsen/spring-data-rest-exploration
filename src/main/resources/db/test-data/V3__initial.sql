INSERT INTO club (id, name) VALUES(1, 'BBC');
INSERT INTO club (id, name) VALUES(2, 'Brønshøj');
INSERT INTO club (id, name) VALUES(3, 'Hillerød BTK');
INSERT INTO club (id, name) VALUES(4, 'Greve BTK');

INSERT INTO player (id, name, version) VALUES(1, 'Jan', CURRENT_DATE);
INSERT INTO player (id, name, version) VALUES(2, 'Samsonov', CURRENT_DATE);
INSERT INTO player (id, name, version) VALUES(3, 'Ohh Sang Eun', CURRENT_DATE);
INSERT INTO player (id, name, version) VALUES(4, 'Maze', CURRENT_DATE);
INSERT INTO player (id, name, version) VALUES(5, 'Monrad', CURRENT_DATE);
INSERT INTO player (id, name, version) VALUES(6, 'Applegreen', CURRENT_DATE);

INSERT INTO match_table (id, when_column, player1_id, player2_id) VALUES(1, CURRENT_DATE, 1, 2);
INSERT INTO match_table (id, when_column, player1_id, player2_id) VALUES(2, CURRENT_DATE, 3, 4);
INSERT INTO match_table (id, when_column, player1_id, player2_id) VALUES(3, CURRENT_DATE, 5, 6);
INSERT INTO match_table (id, when_column, player1_id, player2_id) VALUES(4, CURRENT_DATE, 1, 3);
INSERT INTO match_table (id, when_column, player1_id, player2_id) VALUES(5, CURRENT_DATE, 4, 5);
INSERT INTO match_table (id, when_column, player1_id, player2_id) VALUES(6, CURRENT_DATE, 6, 1);

INSERT INTO club_membership (id, club_id, player_id, member_from) VALUES(1, 1, 1, CURRENT_DATE);
INSERT INTO club_membership (id, club_id, player_id, member_from) VALUES(2, 1, 2, CURRENT_DATE);
INSERT INTO club_membership (id, club_id, player_id, member_from) VALUES(3, 2, 2, CURRENT_DATE);
