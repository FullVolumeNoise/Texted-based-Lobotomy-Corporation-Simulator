USE lobcorp;

CREATE TABLE weapons (
    weapon_id INT,
    abnormality_source_id INT,
    cost INT,
    max_count INT,
    damage_minimum_amount INT,
    damage_maximum_amount INT,
    damage_type VARCHAR(50),
    agent_equipped_id INT
);

CREATE TABLE armors (
    armor_id INT,
    abnormality_source_id INT,
    cost INT,
    max_count INT,
    agent_equipped_id INT
);

CREATE TABLE agents (
    agent_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    department_id VARCHAR(50),
    current_level INT NOT NULL,
    current_health_stat INT,
    max_health_stat INT,
    current_sanity_stat INT,
    max_sanity_stat INT,
    current_armor_id INT,
    current_weapon_id INT,
    isPanicked BOOLEAN
);

CREATE TABLE abnormalities (
    abnormality_id INT primary key,
    name VARCHAR(100) NOT NULL,
    quote VARCHAR(500) NOT NULL,
    description VARCHAR(800)NOT NULL,
    rank CHAR(50) NOT NULL,
    counter_max INT,
    current_counter_value INT,
    max_energy_given INT,
    breachable BOOLEAN NOT NULL,
    armors_id INT,
    weapons_id INT,
    department_id INT,
    currentlyBreaching BOOLEAN
);

INSERT INTO agents(
    agent_id, name, department_id, current_level,
    current_health_stat, max_health_stat,
    current_sanity_stat, max_sanity_stat,
    current_armor_id, current_weapon_id,
    isPanicked
) VALUES 
(1, 'Alice', 1, 3, 80, 100, 60, 100, 1, 1, FALSE),
(2, 'Bob', 2, 2, 90, 90, 70, 100, 2, 2, FALSE),
(3, 'Charlie', 1, 4, 60, 120, 40, 100,1, 2, FALSE),
(4, 'Diana', 3, 1, 100, 100, 100, 100, 3, 1, FALSE),
(5, 'Ethan', 2, 5, 110, 110, 30, 90, 2, NULL, TRUE);

INSERT INTO weapons (
    weapon_id, abnormality_source_id, cost, max_count,
    damage_minimum_amount, damage_maximum_amount, damage_type, agent_equipped_id
) VALUES
(1, 1, 20, 1, 15, 25, 'Red', 1),
(2, 1, 15, 2, 10, 18, 'White', 2),
(3, 2, 30, 1, 20, 35, 'Black', 3),
(4, 3, 10, 3, 5, 10, 'Pale', 4),
(5, 1, 25, 1, 18, 28, 'Red', 5);

INSERT INTO armors (
    armor_id, abnormality_source_id, cost, max_count, agent_equipped_id
) VALUES
(1, 2, 20, 1, 1),
(2, 1, 15, 2, 2),
(3, 3, 30, 1, 3),
(4, 4, 10, 3, 4),
(5, 2, 25, 1, 5);



INSERT INTO abnormalities (
    abnormality_id, name, quote, description, rank, counter_max, current_counter_value,
    max_energy_given, breachable, armors_id, weapons_id, department_id, currentlyBreaching
) VALUES
(1, 'Scorched Girl', "I am coming to you. You, who will be reduced to ash like me.", 
'The Scorched Girl (F-01-02) is an Abnormality in the form of a charred figure resembling a young girl. She has white eyes, a white open mouth, two thin legs, scorched ponytails, and the burnt tip of a lit match penetrating her torso. ', 
'TETH', 2, 2, 12, TRUE, NULL, NULL, NULL, FALSE),
(2, 'One Sin and Hundreds of Good Deeds', 'It feeds on the “evil” that seeps out during conversations between people.',
 'One Sin and Hundreds of Good Deeds (O-03-03), commonly referred to as One Sin, is a relatively harmless Abnormality that is in the shape of a levitating cross, seemingly melded with a skull, both of which are bound tightly together by a thorn crown. ',
  'ZAYIN', NULL, NULL, 10, FALSE, NULL, NULL, NULL, FALSE),
(3, 'The Queen of Hatred', 'In the name of Love and Justice~ Here comes Magical Girl!',
 'The Queen of Hatred (O-01-04), also known as Magical Girl is an Abnormality resembling a young, pale-skinned girl. She has large, yellow, stylized eyes and four-fingered hands. Her long hair has a pastel blue and purple gradient as coloration with two strands curled away in the shape of antenna. She wears white tights with pink accents, a pink, layered/pleated skirt, a pink shirt with white sleeves, and a large pink ribbon on her chest to match. She has two wing-like pieces on her shoulders and a pink and black heart clip in her hair. Beside her is a pink staff topped with a winged a star which has a heart-shaped hole at its center. Its grip is striped with yellow and pink, and the base is tipped with a pale blue heart with a pink star in the center. ',
  'WAW', 2, NULL, 22, TRUE, NULL, NULL, NULL, FALSE),
(4, 'Happy Teddy Bear', 'Its memories began with a warm hug.', 'Happy Teddy Bear (T-04-06) AKA A Teddy Bear is a large, worn-out teddy bear with a chewed ear, a single white button eye, a black hole in place of the other eye, brown matted fur, a light brown muzzle, and a faded green bowtie around its neck. Its stuffing spills out from multiple tears in its fabric.',
 'HE', NULL, NULL, 15, FALSE, NULL, NULL, NULL, FALSE),
(5, 'Red Shoes', 'The girl begged in tears. "Mister, please cut off my feet..."', 'The Red Shoes (O-04-08) are a pair of shiny red high-heels. They sit upon a lilac pillow atop a white podium. The shoes seem to have an abnormal gloss despite their age. It is implied that the shoes have teeth hidden in their confines which bite into skin with extraordinary strength when put on a foot, using so much force that the shoes are irremovable through physical means alone.',
 'HE', 1, NULL, 16 , FALSE, NULL, NULL, NULL, FALSE),
(6, 'Theresia', "'Do you remember this melody? The professor used to play this song when the students were sleepy. Happy birthday.'", "Theresia (T-09-09) is a TETH Tool Abnormality in the form of an ornate and bloodied music box that rests on a blood-soaked wooden stool. There's a wind-up key on the side of the music box and a ballerina performing an arabesque pose on its top. While in use, a cacophonous music box tune can be heard. ",
 'TETH', NULL, NULL, NULL, FALSE, NULL, NULL, NULL, NULL);

SELECT * FROM abnormalities;
SELECT * FROM agents;
SELECT * FROM armors;
SELECT * FROM weapons;

