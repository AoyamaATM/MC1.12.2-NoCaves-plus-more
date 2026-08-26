# Aoyama's NoCaves+more

Minecraft 1.12.2 / Forge 向けのワールド生成制御MODです。  
洞窟、峡谷、地下湖、溶岩生成などを個別に無効化できます。

A world generation control mod for Minecraft 1.12.2 / Forge.  
It allows caves, ravines, underground lakes, lava generation, and other features to be disabled individually.

- Minecraft: **1.12.2**
- Mod Loader: **Minecraft Forge**
- Current Version: **2.0.0**
- Author: **AoyamaATM**

[Modrinth](https://modrinth.com/mod/aoyama-nocaves-more)  
[GitHub](https://github.com/AoyamaATM/)

---

# 日本語

## 概要

**Aoyama's NoCaves+more** は、Minecraft 1.12.2のワールド生成を制御するMODです。

洞窟を削除するだけでなく、峡谷、地下の水湖・溶岩湖、溶岩流、ネザーの洞窟や溶岩生成などを、それぞれ個別に設定できます。

各機能はConfigからON/OFFを切り替えることができます。

## 機能

### オーバーワールド

- 洞窟の生成を無効化
- 峡谷（Ravine）の生成を無効化
- 地下の水湖を無効化
  - 地表の水湖は残します
- 地下の溶岩湖を無効化
  - 地表の溶岩湖は残します
- Lava Springs（地中・壁面などに生成される溶岩流）を無効化

### ネザー

- ネザー洞窟の生成を無効化
  - 普段見るような大空洞には影響しません
- 露出したLava Springsを無効化
- ネザーラック内部に埋まった1マス溶岩（Lava Pockets）を無効化
- ネザーの溶岩海には影響しません

## Config

以下の項目を個別に変更できます。

| 設定 | 初期値 | 内容 |
| --- | --- | --- |
| `removeCaves` | `true` | オーバーワールドの洞窟を削除 |
| `removeRavines` | `true` | オーバーワールドの峡谷を削除 |
| `removeUndergroundWaterLakes` | `true` | 地下の水湖を削除 |
| `removeUndergroundLavaLakes` | `true` | 地下の溶岩湖を削除 |
| `removeLavaSprings` | `true` | オーバーワールドのLava Springsを削除 |
| `removeNetherCaves` | `false` | ネザー洞窟を削除 |
| `removeNetherLavaSprings` | `true` | ネザーの露出したLava Springsを削除 |
| `removeNetherLavaPockets` | `true` | ネザーラック内部のLava Pocketsを削除 |

`removeNetherCaves` のみ、デフォルトでは `false` です。

ConfigはMinecraftのMOD一覧から変更できます。

## 導入方法

1. Minecraft 1.12.2用のForgeを導入します。
2. `Aoyamas-NoCaves-plus-more-2.0.0.jar` を `mods` フォルダに入れます。
3. Minecraftを起動します。
4. 必要に応じてMOD一覧のConfigから設定を変更します。

## 注意

このMODは**ワールド生成時**に処理を行います。

すでに生成されているチャンクの洞窟や湖などを削除するものではありません。  
設定変更後の確認は、新規ワールドまたは未生成チャンクで行ってください。

## MOD互換性

ForgeのTerrain Generation Eventを使用してワールド生成を制御しています。

Minecraft 1.12.2の通常ワールドに加えて、以下の環境で動作確認を行っています。

- The Lost Cities
- Worley's Caves
- Nomifactory CEu 1.7.7

Worley's Cavesなど、バニラの洞窟ジェネレーターを置き換えるMODについても、最終的な洞窟生成を無効化できるようイベント処理順を考慮しています。

ただし、Forgeの標準的な地形生成イベントを使用せず、独自方式で空洞を生成するMODについては完全な互換性を保証できません。

## 2.0.0について

2.0.0ではMODの実装を大幅に見直し、洞窟削除だけでなく各種ワールド生成を個別に制御できるようになりました。

詳細は `CHANGELOG.md` を参照してください。

---

# English

## Overview

**Aoyama's NoCaves+more** is a world generation control mod for Minecraft 1.12.2.

In addition to disabling caves, the mod can individually control ravines, underground water and lava lakes, lava springs, Nether caves, and Nether lava generation.

Each feature can be enabled or disabled through the configuration.

## Features

### Overworld

- Disable cave generation
- Disable ravine generation
- Disable underground water lakes
  - Surface water lakes are preserved
- Disable underground lava lakes
  - Surface lava lakes are preserved
- Disable Lava Springs generated underground or on exposed surfaces

### Nether

- Disable Nether cave generation
- Disable exposed Nether Lava Springs
- Disable hidden single-block lava pockets inside Netherrack
- The Nether lava ocean is not affected

## Configuration

Each feature can be configured individually.

| Option | Default | Description |
| --- | --- | --- |
| `removeCaves` | `true` | Removes Overworld caves |
| `removeRavines` | `true` | Removes Overworld ravines |
| `removeUndergroundWaterLakes` | `true` | Removes underground water lakes |
| `removeUndergroundLavaLakes` | `true` | Removes underground lava lakes |
| `removeLavaSprings` | `true` | Removes Overworld Lava Springs |
| `removeNetherCaves` | `false` | Removes Nether caves |
| `removeNetherLavaSprings` | `true` | Removes exposed Nether Lava Springs |
| `removeNetherLavaPockets` | `true` | Removes hidden lava pockets inside Netherrack |

Only `removeNetherCaves` is disabled by default.

The configuration can be changed from the Minecraft Mods menu.

## Installation

1. Install Minecraft Forge for Minecraft 1.12.2.
2. Place `Aoyamas-NoCaves-plus-more-2.0.0.jar` in the `mods` folder.
3. Start Minecraft.
4. Change the configuration from the Mods menu if necessary.

## Important

This mod modifies **world generation**.

It does not remove caves, lakes, or other features from chunks that have already been generated.

When testing configuration changes, use a new world or generate new chunks.

## Mod Compatibility

This mod controls world generation using Forge terrain generation events.

In addition to normal Minecraft 1.12.2 worlds, it has been tested with:

- The Lost Cities
- Worley's Caves
- Nomifactory CEu 1.7.7

The event handling order is designed so that cave generators which replace the vanilla generator, such as Worley's Caves, can still be disabled by NoCaves+more.

However, compatibility cannot be guaranteed with mods that generate underground cavities using completely independent systems without Forge's standard terrain generation events.

## About Version 2.0.0

Version 2.0.0 significantly reworks the mod and expands it from simple cave removal into configurable world generation control.

See `CHANGELOG.md` for details.
