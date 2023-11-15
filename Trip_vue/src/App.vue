<script setup>
import { RouterView } from "vue-router";
import Header from "./components/common/Header.vue";
// import Footer from "./components/common/Footer.vue";
</script>

<template>
  <!-- route가 home에선 헤더와 푸터 없에기 -->
  <Header></Header>

  <RouterView />

  <!-- <Footer></Footer> -->
</template>

<style scoped></style>
