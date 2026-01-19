package com.leaveplanner.service;

import com.leaveplanner.domain.User;
import com.leaveplanner.repository.InMemoryUserRepository;
import com.leaveplanner.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class UserServiceTest{
  
  private UserService userService;
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
      userRepository = new InMemoryUserRepository();
      userService = new UserService(userRepository);
  }

  @Test
  void 사용자를_정상적으로_생성한다() {
    // given
    String name = "김군인";
    String email = "soldier@army.mil";
    LocalDate enlistmentDate = LocalDate.of(2024, 3, 1);

    // when
    User user = userService.create(name, email, enlistmentDate);

    // then
    assertThat(user.getId()).isNotNull();
    assertThat(user.getName()).isEqualTo(name);
    assertThat(user.getEmail()).isEqualTo(email);
    assertThat(user.getEnlistmentDate()).isEqualTo(enlistmentDate);
    assertThat(user.getCreatedAt()).isNotNull();
  }

  @Test
  void id로_사용자를_조회할_수_있다(){
    // given
    String name = "김군인";
    String email = "soldier@army.mil";
    LocalDate enlistmentDate = LocalDate.of(2024, 3, 1);
    User testUser = userService.create(name, email, enlistmentDate);

    //when
    Optional<User> found = userService.findById(testUser.getId());

    //then
    assertThat(found).isPresent();
    assertThat(found.get().getName()).isEqualTo("김군인");
    
  }

  @Test
  void 존재하지_않는_사용자_조회시_Empty_반환() {
    // when
    Optional<User> found = userService.findById(999L);

    // then
    assertThat(found).isEmpty();
  }

  @Test
  void 전체_사용자_목록을_조회할_수_있다() {
    // given
    userService.create("김군인", "kim@army.mil", LocalDate.of(2024, 3, 1));
    userService.create("이병장", "lee@army.mil", LocalDate.of(2023, 6, 1));
    userService.create("박일병", "park@army.mil", LocalDate.of(2024, 9, 1));

    // when
    List<User> users = userService.findAll();

    // then
    assertThat(users).hasSize(3);
  }

  @Test
  void 입대일이_정확히_저장된다() {
    // given
    LocalDate enlistmentDate = LocalDate.of(2024, 3, 15);

    // when
    User user = userService.create(
        "김신병",
        "new@army.mil",
        enlistmentDate
    );

    // then
    assertThat(user.getEnlistmentDate()).isEqualTo(enlistmentDate);
  }


  
}