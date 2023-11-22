<script setup>
const props = defineProps({ plan: Object });
</script>

<template>
  <div class="item">
    {{ plan.title }}
  </div>
</template>

<style scoped></style>
