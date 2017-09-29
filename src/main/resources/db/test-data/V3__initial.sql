INSERT INTO club (id, name) VALUES(1, 'BBC');
INSERT INTO club (id, name) VALUES(2, 'Brønshøj');
INSERT INTO club (id, name) VALUES(3, 'Hillerød BTK');
INSERT INTO club (id, name) VALUES(4, 'Greve BTK');

INSERT INTO player (id, name, version) VALUES(1, 'Jan', 1);
INSERT INTO player (id, name, version) VALUES(2, 'Samsonov', 1);

INSERT INTO club_membership (id, club_id, player_id, member_from) VALUES(1, 1, 1, CURRENT_DATE);
INSERT INTO club_membership (id, club_id, player_id, member_from) VALUES(2, 1, 2, CURRENT_DATE);
INSERT INTO club_membership (id, club_id, player_id, member_from) VALUES(3, 2, 2, CURRENT_DATE);
