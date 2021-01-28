{ }:

let
  pkgs = import <nixpkgs> { };
  pname = "ScalaWorkshop";
  vsextensions = (with pkgs.vscode-extensions; [
    ms-vsliveshare.vsliveshare
    scalameta.metals
    scala-lang.scala
    vscodevim.vim
  ]) ++ pkgs.vscode-utils.extensionsFromVscodeMarketplace [{
      name = "markdown-mermaid";
      publisher = "bierner";
      version = "1.9.1";
      sha256 = "155m0xrdqjg56fbzvfb8ii313qshr55jbpnc1q9kcvw78dcq81b1";
    } {
      name = "vscode-mermaid-editor";
      publisher = "tomoyukim";
      version = "0.9.2";
      sha256 = "06ggg0zm5dhmvq46hsi2s6wpgdqzsymh7lpclk2cgbkkw16yz7a7";
  }];
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
