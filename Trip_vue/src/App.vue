<script setup>
import { RouterView } from "vue-router";
import { useRoute } from "vue-router";
import Header from "./components/common/Header.vue";
import spinnder from "./components/common/Spinner.vue";
import { ref, watch } from "vue";
import Footer from "./components/common/Footer.vue";
const route = useRoute();
const name = ref("");
const LoadingStatus = ref(false);

watch(
  route,
  () => {
    name.value = route.name;
  },
  { deep: true }
);
</script>

<template>
  <Header v-if="name !== 'Home'"></Header>

  <RouterView />

  <!-- <Footer></Footer> -->
  <spinner :loading="LoadingStatus"></spinner>
</template>

<style>
:root {
  --main-color: #ffa18d;
  --main-color-bg: #f5d7cdff;
}
</style>
