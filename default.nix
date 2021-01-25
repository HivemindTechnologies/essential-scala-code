{ }:

let
  pkgs = import <nixpkgs> { };
  pname = "ScalaWorkshop";
  vsextensions = (with pkgs.vscode-extensions; [
    ms-vsliveshare.vsliveshare
    scalameta.metals
    scala-lang.scala
    vscodevim.vim
  ]);
  vscode-workshop = pkgs.vscode-with-extensions.override {
    vscodeExtensions = vsextensions;
  };
in
  pkgs.mkShell {
    nativeBuildInputs = with pkgs; [
      ammonite
      git zsh
      scala sbt
      visualvm
      jdk11
      vscode-workshop
    ];

    installPhase= ''
    '';

    shellHook=''
    echo --- Welcome to the ${pname}! ---
    '';
  }
