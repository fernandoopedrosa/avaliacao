

INSERT INTO Tag(name) VALUES('TAG 1');
INSERT INTO Tag(name) VALUES('TAG 2');
INSERT INTO Tag(name) VALUES('TAG 3');
INSERT INTO Tag(name) VALUES('TAG 4');
INSERT INTO Tag(name) VALUES('TAG 5');
INSERT INTO Tag(name) VALUES('TAG 6');
INSERT INTO Tag(name) VALUES('TAG 7');
INSERT INTO Tag(name) VALUES('TAG 8');


INSERT INTO Tool(title, link, description) VALUES('TOOL 1', 'http://localhost:8080/rest/tools/1', 'Ferramenta tool 1');
INSERT INTO Tool(title, link, description) VALUES('TOOL 2', 'http://localhost:8080/rest/tools/2', 'Ferramento Tool 2');
INSERT INTO Tool(title, link, description) VALUES('TOOL 3', 'http://localhost:8080/rest/tools/3', 'Ferramenta Tool 3');
INSERT INTO Tool(title, link, description) VALUES('TOOL 4', 'http://localhost:8080/rest/tools/4', 'Ferramenta Tool 4');
INSERT INTO Tool(title, link, description) VALUES('TOOL 5', 'http://localhost:8080/rest/tools/5', 'Ferramenta Tool 5');
INSERT INTO Tool(title, link, description) VALUES('TOOL 6', 'http://localhost:8080/rest/tools/6', 'Ferramenta Tool 6');

INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(3, 1);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(3, 2);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(2, 1);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(1, 2);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(4, 2);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(5, 2);

INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 1);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 2);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 3);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 4);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 5);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 6);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 7);
INSERT INTO TOOL_TAG (FK_TOOL, FK_TAG) VALUES(6, 8);