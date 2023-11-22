<script setup>
import { RouterLink, RouterView } from "vue-router";
import LoginCheck from "@/components/common/LoginCheck.vue";
import { ref } from "vue";
const c = Math.random();
const l = ref(0);

if (c < 0.7) {
  l.value = 0;
} else {
  l.value = 1;
}
</script>
<template>
  <div>
    <RouterLink :to="{ name: 'Home' }">
      <img v-if="l === 0" class="logo" src="@/assets/logo0.svg" alt="logo" />
      <img v-else-if="l === 1" class="logo" src="@/assets/logo1.svg" alt="logo" />
    </RouterLink>

    <nav>
      <div>
        <RouterLink :to="{ name: 'Main' }">메인 화면</RouterLink>
        <RouterLink :to="{ name: 'MyList' }">나의 일정</RouterLink>
        <RouterLink :to="{ name: 'PlanInsert' }">일정 등록</RouterLink>
        <RouterLink :to="{ name: 'BoardList' }">일정 공유하기</RouterLink>
      </div>
      <div>
        <LoginCheck />
      </div>
    </nav>
  </div>
</template>

<style scoped>
div {
  display: flex;
  align-items: center;
  padding: 1rem;

  /* border-bottom: 1px solid var(--color-border); */
}
.logo {
  width: 110px;
  height: 100px;
  margin: 0 0 0 1rem;
}

nav {
  width: 100%;
  font-size: 32px;
  text-align: center;
  margin-top: 2rem;
  display: flex;
  justify-content: space-between;
}

nav a.router-link-exact-active {
  background-color: var(--main-color);
  border-radius: 10px;
  color: white;
  text-decoration: none;
}
nav a.router-link-exact-active:focus {
  background-color: var(--main-color);
  border-radius: 10px;
  color: white;
  text-decoration: none;
}

nav a.router-link-exact-active:hover {
  text-decoration: none;
  color: white;
  font-weight: normal;
}
nav a:focus {
  text-decoration: none;
  color: var(--main-color);
  font-weight: normal;
}
nav a {
  display: inline-block;
  padding: 0 1rem;

  /* border-left: 1px solid var(--color-border); */
}
nav a:hover {
  color: var(--main-color);
  font-weight: bold;

  text-decoration: none;
}
nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  .logo {
    margin: 0 2rem 0 0;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 2rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
  div .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
