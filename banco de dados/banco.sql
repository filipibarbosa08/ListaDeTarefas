-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tarefas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tarefas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tarefas` DEFAULT CHARACTER SET utf8 ;
USE `tarefas` ;

-- -----------------------------------------------------
-- Table `tarefas`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tarefas`.`usuario` (
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tarefas`.`tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tarefas`.`tarefa` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `descricao` VARCHAR(90) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`, `usuario`),
  INDEX `fk_tarefa_usuario_idx` (`usuario` ASC) ,
  CONSTRAINT `fk_tarefa_usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `tarefas`.`usuario` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
