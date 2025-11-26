use bevy::prelude::*;

fn main() {
    App::new()
        .add_plugins(DefaultPlugins)
        .insert_resource(Gravity(-900.0))
        .add_systems(Startup, setup)
        .add_systems(Update, (player_input, apply_gravity, ground_collision))
        .run();
}

#[derive(Component)]
struct Player;

#[derive(Component)]
struct Velocity(Vec2);

#[derive(Resource)]
struct Gravity(f32);

fn setup(mut commands: Commands) {
    commands.spawn(Camera2dBundle::default());

    commands.spawn((
        SpriteBundle {
            sprite: Sprite {
                color: Color::srgb(0.3, 0.8, 1.0),
                custom_size: Some(Vec2::new(40.0, 40.0)),
                ..Default::default()
            },
            transform: Transform::from_xyz(0.0, 50.0, 1.0),
            ..Default::default()
        },
        Player,
        Velocity(Vec2::ZERO),
    ));

    commands.spawn((
        SpriteBundle {
            sprite: Sprite {
                color: Color::srgb(0.3, 0.4, 0.3),
                custom_size: Some(Vec2::new(600.0, 40.0)),
                ..Default::default()
            },
            transform: Transform::from_xyz(0.0, -150.0, 0.0),
            ..Default::default()
        },
    ));
}

fn player_input(
    keyboard: Res<ButtonInput<KeyCode>>,
    mut query: Query<(&mut Velocity, &Transform), With<Player>>,
) {
    let (mut velocity, transform) = query.single_mut();

    let speed = 300.0;
    velocity.0.x = 0.0;

    if keyboard.pressed(KeyCode::KeyA) || keyboard.pressed(KeyCode::ArrowLeft) {
        velocity.0.x = -speed;
    }
    if keyboard.pressed(KeyCode::KeyD) || keyboard.pressed(KeyCode::ArrowRight) {
        velocity.0.x = speed;
    }

    let on_ground = transform.translation.y <= -110.0;
    if on_ground
        && (keyboard.just_pressed(KeyCode::Space)
            || keyboard.just_pressed(KeyCode::KeyW)
            || keyboard.just_pressed(KeyCode::ArrowUp))
    {
        velocity.0.y = 450.0;
    }
}

fn apply_gravity(
    time: Res<Time>,
    gravity: Res<Gravity>,
    mut query: Query<(&mut Transform, &mut Velocity), With<Player>>,
) {
    let (mut transform, mut velocity) = query.single_mut();

    let dt = time.delta_seconds();

    velocity.0.y += gravity.0 * dt;

    transform.translation.x += velocity.0.x * dt;
    transform.translation.y += velocity.0.y * dt;
}

fn ground_collision(mut query: Query<(&mut Transform, &mut Velocity), With<Player>>) {
    let (mut transform, mut velocity) = query.single_mut();

    let ground_y = -110.0;

    if transform.translation.y <= ground_y {
        transform.translation.y = ground_y;
        velocity.0.y = 0.0;
    }
}
